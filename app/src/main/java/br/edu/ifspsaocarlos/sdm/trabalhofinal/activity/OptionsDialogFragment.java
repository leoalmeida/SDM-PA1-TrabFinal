package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

/**
 * Created by LeonardoAlmeida on 20/11/15.
 */
public class OptionsDialogFragment extends DialogFragment {

    private CharSequence[] jogos_opcoes = {"FÁCIL","DIFÍCIL"};

    public interface NoticeDialogListener {
        void onDialogItemClick(DialogFragment dialog, int selection);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.quiz_text_dificuldade)
                .setItems(jogos_opcoes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogItemClick(OptionsDialogFragment.this, which);
                    }
                }).setNegativeButton(R.string.stop_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
