package xyz.gitsieg.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static EditText mEditTextWebsite, mEditTextLocation, mEditTextShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextWebsite = findViewById(R.id.edit_webBrowser);
        mEditTextLocation = findViewById(R.id.edit_location);
        mEditTextShareText = findViewById(R.id.edit_share);

    }

    /**
     * OnClick method for open website button. Fetches URL from EditText, creates a URI.
     * Opens website with default browser.
     * @param view
     */
    public void openWebsite(View view) {
        // Fetch url, create URI object from it
        String url = mEditTextWebsite.getText().toString();
        Uri uri = Uri.parse(url);

        // Create intent with type
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        // Find activity to handle intent, check if it resolves.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Failed to find activity to handle intent
            Log.d(LOG_TAG, "Could not handle intent");
        }
    }

    public void openLocation(View view) {
        String location = mEditTextLocation.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null ) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Could not handle intent");
        }
    }


    /* ShareCompat.IntentBuilder
    * Method 	Description
    from() 	The activity that launches this share intent (this).
    setType() 	The MIME type of the item to be shared.
    setChooserTitle() 	The title that appears on the system app chooser.
    setText() 	The actual text to be shared
    startChooser() 	Show the system app chooser and send the intent.
    *
    * */
    public void shareText(View view) {
        String text = mEditTextShareText.getText().toString();
        String mime = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mime)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();

    }
}
