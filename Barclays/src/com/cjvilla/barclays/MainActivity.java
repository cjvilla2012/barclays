/** Copyright 2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * The one and only Activity for this test app. When it is resumed, it retrieves
 * the offers, thenshows them in the ProductFragment.
 *
 */
public class MainActivity extends Activity {
	private Offers offers;
	public Product[] getProducts() {return offers.getOffers();}
	public void setProducts(Offers offers) {this.offers=offers;}
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/** Cancel and null the ProgressDialog */
	public void cancelProgress() {
		if (pd!=null) {
			pd.dismiss();
			pd=null;
		}
	}
	
	/** Create a transparent dialog with a spinner.
	 * See <a href="http://stackoverflow.com/questions/16980404/display-progressdialog-without-text-android">this</a>
	 */
	public void createProgress(DialogInterface.OnCancelListener cancel) {
		
		pd = new ProgressDialog(this);
		pd.setCancelable(true);
		pd.setIndeterminate(true);
		pd.setOnCancelListener(cancel);
		pd.show();	
        pd.setContentView(R.layout.progress_transparent);
	}
	
	/** Anytime the Activity enters the resumed state, start the GetProductsTask.
	 * @see GetProductsTask
	 */
	public void onResume() {
		super.onResume();
		new GetProductsTask(this).execute();
	}
	
	/** Show an alert message moda dialog.
	 * 
	 * @param message Message to show
	 */
	public void showAlert(String message) {
	    Alert newFragment = Alert.newInstance(
	            R.string.error,message);
	    newFragment.show(getFragmentManager(), "alert");		
	}
	
	/** Called when OK is tapped in Alert. Default implementation does nothing */
    public void ok() {}
    
    /** Called when Cancel is tapped in Alert. Default implementation does nothing */
    public void cancel() {}	
	
    /** Set the Offers instance, then replace the current Fragment
     * with a ProductListFragment.
     * 
     * @param offers	Non-null Offers
     */
    public void showProducts(Offers offers) {
    	setProducts(offers);
    	Fragment fragment=new ProductListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.main_fragment, fragment)
                       .commit();    	
    }	
}
