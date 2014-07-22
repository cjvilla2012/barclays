/** Copyright 2010-2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Displays a single Product from the offers. The position of the Product
 * within the array of Products with the Offers instance is set as
 * an argument when the ProductFragment is instantiated.
 *
 */
public class ProductFragment extends Fragment {
	private static final String KEY_POSITION="kpos";
	 
	 public static ProductFragment instance(int position) {
		 ProductFragment pf=new ProductFragment();
		 Bundle b=new Bundle();
		 b.putInt(KEY_POSITION, position);
		 pf.setArguments(b);
		 return pf;
	 }
	 
	 /** Get a Product out of the MainActivity products, set it into
	  * a ProductView associated with the inflated View, and return that
	  * View.
	  */
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	    Bundle savedInstanceState) {  
		View v=inflater.inflate(R.layout.fragment_product, container,false);
		int position=getArguments().getInt(KEY_POSITION);
		Product product=((MainActivity)getActivity()).getProducts()[position];
		ProductView pv=new ProductView(getActivity(),v);
		pv.setItems(product);
		return v;
	} 

}
