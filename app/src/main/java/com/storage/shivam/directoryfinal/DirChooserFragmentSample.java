package com.storage.shivam.directoryfinal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.rdrei.android.dirchooser.DirectoryChooserFragment;
import net.rdrei.android.dirchooser.sample.R;


public class DirChooserFragmentSample extends Activity implements DirectoryChooserFragment.OnFragmentInteractionListener {

    private TextView mDirectoryTextView;
    private DirectoryChooserFragment mDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        //Pass the previously selected path.
        mDialog = DirectoryChooserFragment.newInstance("AudioRecorder", Environment.getExternalStorageDirectory() + "/AudioRecorder");
        mDirectoryTextView = (TextView) findViewById(R.id.textDirectory);
        findViewById(R.id.btnChoose)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.show(getFragmentManager(), null);
                    }
                });
    }

    @Override
    public void onSelectDirectory(final String path) {
        mDirectoryTextView.setText(path);
        //Store the selected path (path) somewhere.
        mDialog.dismiss();
    }

    @Override
    public void onCancelChooser() {
        mDialog.dismiss();

    }
}