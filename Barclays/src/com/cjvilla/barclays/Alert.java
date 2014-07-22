/** Copyright 2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/** This may be used either as an Alert dialog, with an OK button, or
 * as a confirmation dialog, with OK and Cancel buttons. Clicking these
 * buttons calls back to the ok and cancel methods in MainActivity,
 * so using this class with something other than a MainActivity will
 * cause a ClassCastException.
 * @author cjvilla
 *
 */
public class Alert extends DialogFragment {
	 public static Alert newInstance(int titleResID,String message) {
	 Alert frag = new Alert();
        Bundle args = new Bundle();
        args.putInt("title", titleResID);
        args.putString("message", message);	
        args.putBoolean("confirm", false);
        frag.setArguments(args);
        return frag;
    }
	 
	 /** Creates a confirmation dialog with OK and Cancel buttons.
	  * 
	  * @param titleResID	Resource ID of title
	  * @param message		String message
	  * @return				An Alert
	  */
	 public static Alert confirm(int titleResID,String message) {
	 Alert frag = new Alert();
        Bundle args = new Bundle();
        args.putInt("title", titleResID);
        args.putString("message", message);
        args.putBoolean("confirm", true);
        frag.setArguments(args);
        return frag;
    }	 

    @Override
    /** Create the Alert Dialog. It always has an OK button. If this is tapped
     * then dialog is dismissed and the MainActivity ok method is called.
     * Optionally if this is a confirmation dialog there is a Cnacel button which,
     * if tapped, calls the MainActivity cancel method.
     * @throws ClassCastException If the parent Activity is not a MainActivity
     */
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int titleResID = getArguments().getInt("title");
        Builder builder=new Builder(getActivity());
        builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(titleResID)
                .setMessage(getArguments().getString("message"))
                .setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.dismiss();
                            ((MainActivity)getActivity()).ok();
                        }
                    }
                );
        if (getArguments().getBoolean("confirm")) {
        	builder.setCancelable(true);
        	builder.setNegativeButton(R.string.cancel,
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    dialog.dismiss();
                    ((MainActivity)getActivity()).cancel();
                }
            }
        );
        }
        return builder.create();
    }
}
