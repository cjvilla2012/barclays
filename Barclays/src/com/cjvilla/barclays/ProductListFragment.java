/** Copyright 2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Displays the list of Products retrieved in the Offers object.
 *
 */
public class ProductListFragment extends ListFragment {
	
	/** When an item is clicked, instantiation a ProductFragment with
	 * the item position, then replace the current Fragment with this
	 * ProductFragment. Add the transaction to the back stack so that the BACK
	 * key returns to this ProductListFragment.
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		ProductFragment pf=ProductFragment.instance(position);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.main_fragment, pf)
                       .addToBackStack(null)
                       .commit();
	}	

	 @Override  
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	    Bundle savedInstanceState) {  
		   ProductAdapter adapter = new ProductAdapter(getActivity(),
				   ((MainActivity)getActivity()).getProducts());  
		   setListAdapter(adapter);  
		   return super.onCreateView(inflater, container, savedInstanceState);  
	  } 
 	 
	 
	 /** Manages the data associated with the ListFragment.
	  *
	  */
	 private class ProductAdapter extends BaseAdapter {  
	      private Activity mContext;  
	      private Product[] offers; 

	      /**
	       * 
	       * @param context	Calling Context
	       * @param list	The Products to be displated
	       */
	      public ProductAdapter(Activity context, Product[] list) {  
	           mContext = context;  
	           offers = list;  
	      }  
	      @Override  
	      public int getCount() {  
	           return offers.length;  
	      }  
	      @Override  
	      public Object getItem(int pos) {  
	           return offers[pos];  
	      }  
	      @Override  
	      public long getItemId(int position) {  
	           return position;  
	      }  
	      
	      /** Instantiate a ProductView and set its item content from the
	       * Product at the adapter position.
	       */
	      @Override  
	      public View getView(int position, View convertView, ViewGroup parent) {  
	           View v = convertView;  
	           ProductView pv;
	           if (convertView == null) {  
	                LayoutInflater li = (LayoutInflater) mContext  
	                          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	                v = li.inflate(R.layout.list_item_product_detail, parent,false);  
	                pv=new ProductView(mContext,v);
	                v.setTag(pv);  
	           } else {  
	                pv = (ProductView) v.getTag();  
	           }  
	           pv.setItems(offers[position]);  
	           return v;  
	      } 

	 }  

	 
}
