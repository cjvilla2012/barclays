package com.cjvilla.barclays;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import android.content.DialogInterface;
import android.os.AsyncTask;

/** Uses Retrofit to retrieve the Offers on a background thread.
 * 
 * @author cjvilla
 *
 */
public class GetProductsTask extends AsyncTask<String,Void,Offers>{
	private MainActivity activity;

	public GetProductsTask(MainActivity activity) {
		this.activity=activity;
	}
	
	/** Creates a cancelable ProgressDialog. If the dialog is cancelled,
	 * the AsyncTask is also cancelled.
	 * @see AsyncTask#cancel(boolean)
	 */
	@Override
	protected void onPreExecute() {
		activity.createProgress(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				cancel(true);
			}
		});
	}
	
	/** Creates and executes the RestAdapter for the offers endpoint.
	 * An ErrorHandler is attached that will cancel the progress dialog
	 * and the AsyncTask if it is executed, and show an Alert.
	 */
	@Override
	protected Offers doInBackground(String... tripID) {
		RestAdapter restAdapter = new RestAdapter.Builder()
		  .setEndpoint("https://www.bespokeoffers.co.uk") // The base API endpoint.
		  .setErrorHandler(new ErrorHandler() {
			
			@Override
			public Throwable handleError(RetrofitError error) {
				activity.cancelProgress();
				activity.showAlert(error.getMessage());
				cancel(true);
				return null;
			}
		})
		  .build();

		ProductInterface prod = restAdapter.create(ProductInterface.class);
		return prod.products();
	}
	
	/** Called when the AsyncTask finishes. The ProgressDialog is cancelled
	 * and, if the AsyncTask has not been cancelled, showProducts is called.
	 * @see MainActivity#showProducts(Offers)
	 */
	@Override
	protected void onPostExecute(Offers products) {
		activity.cancelProgress();
		if (!isCancelled()) {
			activity.showProducts(products);
		}
	}

}
