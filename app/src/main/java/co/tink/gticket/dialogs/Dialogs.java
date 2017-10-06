package co.tink.gticket.dialogs;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.tink.gticket.R;


public class Dialogs {

    SharedPreferences prefs;
//    EditPrefs save_prefs;

    View view;
    EditText
            stat_weight,
            stat_chest,
            stat_waist,
            stat_biceps,
            stat_hip,
            stat_forearm,
            stat_calf,
            stat_deadlift,
            stat_benchpress,
            stat_squats;
//            stat_pushupspeck,
//            stat_pushupsshoulders,
//            stat_pushupsarms,
//            stat_pullups,
//            stat_hyperext,
//            stat_squatsofp,
//            stat_crunches;

    TextView kg, cm,
            stat_date,
            stat_weight_tv,
            stat_chest_tv,
            stat_waist_tv,
            stat_biceps_tv,
            stat_hip_tv,
            stat_forearm_tv,
            stat_calf_tv,
            stat_deadlift_tv,
            stat_benchpress_tv,
            stat_squats_tv;

//    Spinner choose_split;

    FloatingActionButton fab;

    GridLayout grid_container;

    AlertDialog.Builder builder;
    AlertDialog alert;
    LayoutInflater inflater;
    Context context;


    String units_weight = "";
    String units_lenght = "";
    String date_sort = "";
    private int mYear;
    private int mMonth;
    private int mDay;
    public List<EditText> edit_texts = new ArrayList<EditText>();

    public String[] prefs_keys = {
            "weight",
            "chest",
            "waist",
            "biceps",
            "hip",
            "forearm",
            "calf",
            "deadlift",
            "bench_press",
            "squats"
//            "push_ups_peck",
//            "push_ups_shoulders",
//            "push_ups_arms",
//            "pull_ups",
//            "hyperext",
//            "squats_ofp",
//            "crunches"
    };

    Calendar calendar;
    int selection = -1;
    String color;
    String[] color_array;

    public Dialogs(Context context) {
        this.context = context;
    }

    public void ExitDialog() {
        builder = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.exit))
                .setMessage(context.getString(R.string.exit_message))
                .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id1) {
                        ((Activity) context).finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id1) {
                                dialog.cancel();
                            }
                        }
                );

        alert = builder.create();

        alert.setCancelable(true);
        alert.show();
    }

//    public void SpinnerDialog(int array) {
//
//        builder = new AlertDialog.Builder(context)
//                .setTitle()
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        dialog.cancel();
//                    }
//                });
//
//        inflater = ((Activity) context).getLayoutInflater();
//        view = inflater.inflate(R.layout.layout_about, null);
//        builder.setView(view);
//
//        alert = builder.create();
//        alert.setCancelable(true);
//        alert.show();
//    }


//
//    public void ExitWorkoutDialog() {
//        builder = new AlertDialog.Builder(context, R.style.DialogWide)
//                .setTitle(context.getString(R.string.finish_wo))
//                .setMessage(context.getString(R.string.finish_wo_message))
//
//                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        ActivityMain.isWorkoutRunning = false;
//                        ((ActivityWorkout) context).get_results();
////                        ((Activity) context).finish();
//                    }
//                })
//                .setNeutralButton(R.string.dont_save, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        ActivityMain.isWorkoutRunning = false;
//                        ((Activity) context).finish();
//                    }
//                })
//                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id1) {
//                                dialog.cancel();
//                            }
//                        }
//                );
//
//        alert = builder.create();
//
//        alert.setCancelable(true);
//        alert.show();
//    }
//
//    public void ColorPickerDialog(final String prefs_key, final View set_color_view, final int color_int) {
//        color_array = context.getResources().getStringArray(R.array.color);
//
//        builder = new AlertDialog.Builder(context, R.style.DialogNarrow)
//                .setTitle(context.getString(R.string.set_color))
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        if (set_color_view instanceof CardView) {
//                            if (!color.equals("") || color.length() != 0 || color != null || !color.isEmpty()) {
//                                ((CardView) set_color_view).setCardBackgroundColor(Color.parseColor(color));
//                            }
//                        } else {
//                            set_color_view.setBackgroundColor(Color.parseColor(color));
//                        }
//                    }
//                })
//                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id1) {
//                                dialog.cancel();
//                            }
//                        }
//                );
//
//        inflater = ((Activity) context).getLayoutInflater();
//        view = inflater.inflate(R.layout.layout_pick_color_dialog, null);
//        builder.setView(view);
//
//        grid_container = (GridLayout) view.findViewById(R.id.grid_container);
//
//        for (int i = 0; i < color_array.length; i++) {
//            final int position;
//            position = i;
//            View fab_layout = LayoutInflater.from(context).inflate(R.layout.item_grid_color, null);
//            fab = (FloatingActionButton) fab_layout.findViewById(R.id.fab);
//            fab.setId(i);
//
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ((FloatingActionButton) view).setImageResource(R.drawable.done_alpha);
//                    deselect(grid_container);
//                    selection = position;
//                    color = color_array[position];
//                    EditPrefs editPrefs = new EditPrefs(context);
//                    editPrefs.SavePrefsString(prefs_key, color);
//                }
//            });
//
//            grid_container.addView(fab_layout);
//
//            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color_array[i])));
//            if (i == selection) {
//                fab.setImageResource(R.drawable.done_alpha);
//            }
//
//            if (set_color_view instanceof CardView) {
//                if (color_int == Color.parseColor(color_array[i])) {
//                    fab.setImageResource(R.drawable.done_alpha);
//                    color = color_array[i];
//                }
//            }
//        }
//
//        alert = builder.create();
//
//        alert.setCancelable(true);
//        alert.show();
//    }
//
//    public void AddStatEntryDialog(final Context context) {
//        save_prefs = new EditPrefs(context);
//        builder = new AlertDialog.Builder(context, R.style.DialogWide)
////                .setTitle(context.getResources().getString(R.string.add_today_statistics))
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        FragmentStatistics fragment = new FragmentStatistics();
//
//                        DBManager manager = new DBManager(context);
//
//                        for (int i = 0; i < manager.tables.length; i++) {
//                            manager.save_line_point(i,
//                                    edit_texts.get(i).getText().toString(),
//                                    stat_date.getText().toString(),
//                                    date_sort);//todo epoch time
//                        }
//
//                        for (int j = 0; j < prefs_keys.length; j++) {
//                            save_prefs.SavePrefsString(prefs_keys[j], edit_texts.get(j).getText().toString());
//                        }
//
//
//                        ((ActivityMain) context).show_fragment(context.getResources().getString(R.string.statistics), new FragmentStatistics(), null, false);
//                    }
//                })
//                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id1) {
//                                dialog.cancel();
//                            }
//                        }
//                );
//
//        inflater = ((Activity) context).getLayoutInflater();
//        view = inflater.inflate(R.layout.layout_statistics_dialog, null);
//        builder.setView(view);
//
//        calendar = Calendar.getInstance();
//        mYear = calendar.get(Calendar.YEAR);
//        mMonth = calendar.get(Calendar.MONTH);
//        mDay = calendar.get(Calendar.DAY_OF_MONTH);
//
//        prefs = context.getSharedPreferences("APP_PREFERENCES", context.MODE_PRIVATE);
//        if (prefs.contains("metric")) {
//            if (prefs.getBoolean("metric", true)) {
//                units_weight = context.getResources().getString(R.string.kg);
//                units_lenght = context.getResources().getString(R.string.cm);
//            } else {
//                units_weight = context.getResources().getString(R.string.lbs);
//                units_lenght = context.getResources().getString(R.string.inch);
//            }
//        } else {
//            units_weight = context.getResources().getString(R.string.kg);
//            units_lenght = context.getResources().getString(R.string.cm);
//        }
//
////        choose_split = (Spinner) view.findViewById(R.id.choose_split);
//
//
//        stat_weight = (EditText) view.findViewById(R.id.stat_weight);
//
//        stat_date = (TextView) view.findViewById(R.id.stat_date);
//
//        stat_chest = (EditText) view.findViewById(R.id.stat_chest);
//        stat_waist = (EditText) view.findViewById(R.id.stat_waist);
//        stat_biceps = (EditText) view.findViewById(R.id.stat_biceps);
//        stat_hip = (EditText) view.findViewById(R.id.stat_hip);
//        stat_forearm = (EditText) view.findViewById(R.id.stat_forearm);
//        stat_calf = (EditText) view.findViewById(R.id.stat_calf);
//
//        stat_deadlift = (EditText) view.findViewById(R.id.stat_deadlift);
//        stat_benchpress = (EditText) view.findViewById(R.id.stat_bench_press);
//        stat_squats = (EditText) view.findViewById(R.id.stat_squats);
//
//
//        stat_weight_tv = (TextView) view.findViewById(R.id.stat_weight_tv);
//
//        stat_chest_tv = (TextView) view.findViewById(R.id.stat_chest_tv);
//        stat_waist_tv = (TextView) view.findViewById(R.id.stat_waist_tv);
//        stat_biceps_tv = (TextView) view.findViewById(R.id.stat_biceps_tv);
//        stat_hip_tv = (TextView) view.findViewById(R.id.stat_hip_tv);
//        stat_forearm_tv = (TextView) view.findViewById(R.id.stat_forearm_tv);
//        stat_calf_tv = (TextView) view.findViewById(R.id.stat_calf_tv);
//
//        stat_deadlift_tv = (TextView) view.findViewById(R.id.stat_deadlift_tv);
//        stat_benchpress_tv = (TextView) view.findViewById(R.id.stat_bench_press_tv);
//        stat_squats_tv = (TextView) view.findViewById(R.id.stat_squats_tv);
//
////        stat_pushupspeck = (EditText) view.findViewById(R.id.stat_push_ups_peck);
////        stat_pushupsshoulders = (EditText) view.findViewById(R.id.stat_push_ups_shoulders);
////        stat_pushupsarms = (EditText) view.findViewById(R.id.stat_push_ups_arms);
////        stat_pullups = (EditText) view.findViewById(R.id.stat_pull_ups);
////        stat_hyperext = (EditText) view.findViewById(R.id.stat_hyperext);
////        stat_squatsofp = (EditText) view.findViewById(R.id.stat_squats_ofp);
////        stat_crunches = (EditText) view.findViewById(R.id.stat_crunches);
//
//
//        edit_texts.add(0, stat_weight);
//        edit_texts.add(1, stat_chest);
//        edit_texts.add(2, stat_waist);
//        edit_texts.add(3, stat_biceps);
//        edit_texts.add(4, stat_forearm);
//        edit_texts.add(5, stat_hip);
//        edit_texts.add(6, stat_calf);
//        edit_texts.add(7, stat_deadlift);
//        edit_texts.add(8, stat_benchpress);
//        edit_texts.add(9, stat_squats);
////        edit_texts.add(10, stat_pushupspeck);
////        edit_texts.add(11, stat_pushupsshoulders);
////        edit_texts.add(12, stat_pushupsarms);
////        edit_texts.add(13, stat_pullups);
////        edit_texts.add(14, stat_hyperext);
////        edit_texts.add(15, stat_squatsofp);
////        edit_texts.add(16, stat_crunches);
//
//        stat_chest_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_chest_tv.getText().toString())));
//        stat_waist_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_waist_tv.getText().toString())));
//        stat_biceps_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_biceps_tv.getText().toString())));
//        stat_hip_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_hip_tv.getText().toString())));
//        stat_forearm_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_forearm_tv.getText().toString())));
//        stat_calf_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_calf_tv.getText().toString())));
//        stat_deadlift_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_deadlift_tv.getText().toString())));
//        stat_benchpress_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_benchpress_tv.getText().toString())));
//        stat_squats_tv.setTextColor(Color.parseColor(Colors.set_color(context, stat_squats_tv.getText().toString())));
//
//        stat_chest.setTextColor(Color.parseColor(Colors.set_color(context, stat_chest_tv.getText().toString())));
//        stat_waist.setTextColor(Color.parseColor(Colors.set_color(context, stat_waist_tv.getText().toString())));
//        stat_biceps.setTextColor(Color.parseColor(Colors.set_color(context, stat_biceps_tv.getText().toString())));
//        stat_hip.setTextColor(Color.parseColor(Colors.set_color(context, stat_hip_tv.getText().toString())));
//        stat_forearm.setTextColor(Color.parseColor(Colors.set_color(context, stat_forearm_tv.getText().toString())));
//        stat_calf.setTextColor(Color.parseColor(Colors.set_color(context, stat_calf_tv.getText().toString())));
//        stat_deadlift.setTextColor(Color.parseColor(Colors.set_color(context, stat_deadlift_tv.getText().toString())));
//        stat_benchpress.setTextColor(Color.parseColor(Colors.set_color(context, stat_benchpress_tv.getText().toString())));
//        stat_squats.setTextColor(Color.parseColor(Colors.set_color(context, stat_squats_tv.getText().toString())));
//
//
//        stat_weight_tv.append(", " + units_weight);
//        stat_chest_tv.append(", " + units_lenght);
//        stat_waist_tv.append(", " + units_lenght);
//        stat_biceps_tv.append(", " + units_lenght);
//        stat_hip_tv.append(", " + units_lenght);
//        stat_forearm_tv.append(", " + units_lenght);
//        stat_calf_tv.append(", " + units_lenght);
//        stat_deadlift_tv.append(", " + units_weight);
//        stat_benchpress_tv.append(", " + units_weight);
//        stat_squats_tv.append(", " + units_weight);
//
//        for (int j = 0; j < prefs_keys.length; j++) {
//            edit_texts.get(j).setText(prefs.getString(prefs_keys[j], ""));
//        }
//
//        updateDate();
//
//        stat_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog dialog = new DatePickerDialog(context, R.style.DatePickerTheme, dateSetListener, mYear, mMonth, mDay);
//                dialog.show();
//            }
//        });
//
////        choose_split.setSelection(prefs.getInt("split", 3) - 1);
////
////        choose_split.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
////            @Override
////            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////                prefs.edit().putInt("split", i + 1).commit();
////            }
////
////            @Override
////            public void onNothingSelected(AdapterView<?> adapterView) {
////
////            }
////        });
//
//        alert = builder.create();
//        alert.setCancelable(true);
//        alert.show();
//    }
//
//    public ProgressDialog ShowProgressDialog() {
//        ProgressDialog progressDialog;
//        progressDialog = ProgressDialog.show(context, null, null, true, false);
//        progressDialog.setCancelable(false);
//        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        progressDialog.setContentView(R.layout.layout_dialog_progressbar);
//        return progressDialog;
//    }
//
//    public void DismissProgressDialog(ProgressDialog progressDialog) {
//        progressDialog.dismiss();
//    }
//
//    public void DeleteFileDialog(final String file_name) {
//
//        builder = new AlertDialog.Builder(context, R.style.DialogNarrow)
//                .setTitle(context.getString(R.string.delete_file))
//                .setMessage(context.getString(R.string.delete_file) + " \"" + file_name + "\"?")
//
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id1) {
//                        File dir = new File(Environment.getExternalStorageDirectory(), "BodyBuilding");
//                        File file = new File(dir + "/" + file_name);
//                        boolean deleted = file.delete();
//
//                        if (deleted) {
//
//                            FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
//                            FragmentTransaction transaction = fragmentManager.beginTransaction();
//                            Animations.visible(((ActivityMain) context).fragments, true);
//                            ((ActivityMain) context).back_arrow.setImageResource(R.drawable.ic_close_white_24dp);
//                            Fragment fragment = new FragmentFilesList();
//                            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
//                            transaction.replace(R.id.pop_up_frame, fragment);
//                            transaction.commit();
//                            ((ActivityMain) context).isPopUp = true;
//                            ((ActivityMain) context).pop_up_toolbar_title.setText(context.getString(R.string.open_files_list));
//
//                            Toast.makeText(context, context.getResources().getString(R.string.done_editing), Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(context, context.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                })
//                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id1) {
//                                dialog.cancel();
//                            }
//                        }
//                );
//
//        alert = builder.create();
//
//        alert.setCancelable(true);
//        alert.show();
//    }
//
//
//    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            mYear = year;
//            mMonth = monthOfYear;
//            mDay = dayOfMonth;
//            updateDate();
//        }
//    };
//
//    private void updateDate() {
//        stat_date.setText(
//                new StringBuilder()
//                        // Month is 0 based so add 1
//                        .append(mDay).append("-")
//                        .append(mMonth + 1).append("-")
//                        .append(mYear));
//
//        if (mMonth < 9) {
//            if (mDay < 10) {
//                date_sort = String.valueOf(mYear) + "0" + String.valueOf(mMonth + 1) + "0" + String.valueOf(mDay);
//            } else {
//                date_sort = String.valueOf(mYear) + "0" + String.valueOf(mMonth + 1) + String.valueOf(mDay);
//            }
//        } else {
//            if (mDay < 10) {
//                date_sort = String.valueOf(mYear) + String.valueOf(mMonth + 1) + "0" + String.valueOf(mDay);
//            } else {
//                date_sort = String.valueOf(mYear) + String.valueOf(mMonth + 1) + String.valueOf(mDay);
//            }
//        }
//    }
//
//    private void deselect(GridLayout parent) {
//        if (selection != -1) {
//            FloatingActionButton fab_ = (FloatingActionButton) parent.findViewById(selection);
//            fab_.setImageResource(android.R.color.transparent);
//        }
//    }
}
