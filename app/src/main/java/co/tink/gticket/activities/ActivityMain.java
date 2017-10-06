package co.tink.gticket.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import co.tink.gticket.R;
import co.tink.gticket.dialogs.Dialogs;
import co.tink.gticket.fragments.FragmentTicketSearchInputs;

public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener, View.OnClickListener {

    public Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    public FrameLayout content_frame;
    ActionBarDrawerToggle toggle;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_views();
        drawer();
        toolbar();
        handler = new Handler();
        show_fragment(new FragmentTicketSearchInputs(), false);
    }

    private void init_views() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        content_frame = (FrameLayout) findViewById(R.id.content_frame);
    }

    private void drawer() {
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void toolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_ticket_search) {
            show_fragment(new FragmentTicketSearchInputs(), false);
        }

        if (id == R.id.nav_history) {

        }

        if (id == R.id.nav_ask_question) {

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                Dialogs dialogs = new Dialogs(this);
                dialogs.ExitDialog();
//            super.onBackPressed();
            }
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.edit, menu);
//        menu.findItem(R.id.action_save).setVisible(false).setEnabled(false);
//        menu.findItem(R.id.action_edit).setVisible(false).setEnabled(false);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
            } else {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void show_fragment(final Fragment fragment, final boolean add) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Bundle data = new Bundle();
//                data.putStringArray("titles", titles);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                fragment.setArguments(data);
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

                if (add) {
                    transaction.replace(R.id.content_frame, fragment).addToBackStack(null);
//                    toolbar.setTitle(string);
                } else {
                    transaction.replace(R.id.content_frame, fragment);
//                    toolbar.setTitle(string);
                }

                transaction.commit();
            }
        }, 250L);
    }

    public void remove_fragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragment != null) {
            transaction.remove(fragment).commit();
        }
    }

//    public void close_pop_up() {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.remove(getSupportFragmentManager().findFragmentById(R.id.pop_up_frame)).commit();
//        Animations.visible(fragments, false);
//        isPopUp = false;
//        pop_up_toolbar_title.setText("");
//    }

    @Override
    public void onBackStackChanged() {
        int stack_size = getSupportFragmentManager().getBackStackEntryCount();
        if (stack_size > 0) {
            toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
            toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp); //set your own
        } else {
            toggle.setDrawerIndicatorEnabled(true); //enable "hamburger to arrow" drawable

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

//            case R.id.back_arrow:
//                if (isPopUp) {
//                    if (isContent) {
//                        isContent = false;
//                        FragmentManager fragmentManager = getSupportFragmentManager();
//                        if (fragmentManager.getBackStackEntryCount() > 0) {
//                            fragmentManager.popBackStack();
//                            pop_up_toolbar_title.setText(getResources().getString(R.string.open_files_list));
//                            back_arrow.setImageResource(R.drawable.ic_close_white_24dp);
//                        }
//                    } else {
//                        close_pop_up();
//                    }
//                }
//                break;
//
//            case R.id.stats:
//                drawer.closeDrawer(GravityCompat.START);
//                show_fragment(getResources().getString(R.string.statistics), new FragmentStatistics(), null, false);
//                break;
        }
    }
}
