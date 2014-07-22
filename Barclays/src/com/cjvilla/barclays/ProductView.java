package com.cjvilla.barclays;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
/** Contains all of the widgets needed to render a display of a product,
 * irrespective of the layout format.
 *
 */
public class ProductView {
	 private Context context;
	 private TextView tvCaption;
	 private TextView tvDate;
	 private TextView tvRedemptionDate;
	 private TextView tvAvailable;		 
	 private TextView tvDescription;
	 private ImageView ivPost;
	 
	 public ProductView(Context context,View v){
		 this.context=context;
		 tvCaption=((TextView)v.findViewById(R.id.title));
		 tvDate=((TextView)v.findViewById(R.id.end_date));	
		 tvRedemptionDate=((TextView)v.findViewById(R.id.redemption_date));				 
		 tvDescription=((TextView)v.findViewById(R.id.description));
		 tvAvailable=(TextView)v.findViewById(R.id.available_count);
		 ivPost=(ImageView)v.findViewById(R.id.img_product);
	 }
	 
	 public void setItems(Product product) {
   	  if (!TextUtils.isEmpty(product.getTitle())) {
   		  tvCaption.setText(product.getTitle());
   	  }
   	  if (!TextUtils.isEmpty(product.getEnd_date())) {
   		  tvDate.setText(product.getEnd_date());
   	  }
   	  if (!TextUtils.isEmpty(product.getEarliest_redemption_date())) {
   		  tvRedemptionDate.setText(product.getEarliest_redemption_date());
   	  }	    	  
   	  if (!TextUtils.isEmpty(product.getDescription())) {
   		  tvDescription.setText(product.getDescription());
   	  }
   	  if (!TextUtils.isEmpty(product.getAvailable_count())) {
   		  tvAvailable.setText(product.getAvailable_count());
   	  }	    	  
   	  if (!TextUtils.isEmpty(product.getImage())) {
   		  Picasso.with(context).load(product.getImage()).into(ivPost);	    		  
   	  }			 
	 }
}
