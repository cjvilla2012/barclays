/** Copyright 2010-2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Simply a placeholder Fragment for the MainActivity until the Offers are 
 * loaded.
 *
 */
public class LoadingFragment extends Fragment {

	 @Override  
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	    Bundle savedInstanceState) {  
	   return inflater.inflate(R.layout.fragment_loading, container,false); 
	  } 	
}
