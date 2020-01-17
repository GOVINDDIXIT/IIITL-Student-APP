package govind.iiitl.app.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import govind.iiitl.app.fragments.Fri;
import govind.iiitl.app.fragments.Mon;
import govind.iiitl.app.fragments.Thu;
import govind.iiitl.app.fragments.Tue;
import govind.iiitl.app.fragments.Wed;


public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Mon();
                break;
            case 1:
                fragment = new Tue();
                break;
            case 2:
                fragment = new Wed();
                break;
            case 3:
                fragment = new Thu();
                break;
            case 4:
                fragment = new Fri();
                break;
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return 5;
    }
}
