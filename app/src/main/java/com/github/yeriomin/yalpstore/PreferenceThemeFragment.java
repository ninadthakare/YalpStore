package com.github.yeriomin.yalpstore;

import android.preference.ListPreference;
import android.preference.Preference;

public class PreferenceThemeFragment extends PreferenceFragment {

    private ListPreference themePreference;

    public PreferenceThemeFragment(PreferenceActivity activity) {
        super(activity);
    }

    public void setThemePreference(ListPreference themePreference) {
        this.themePreference = themePreference;
    }

    @Override
    public void draw() {
        Preference.OnPreferenceChangeListener listener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, final Object newValue) {
                preference.setSummary(activity.getString(getThemeSummaryStringId((String) newValue)));
                return true;
            }
        };
        listener.onPreferenceChange(themePreference, themePreference.getValue());
        themePreference.setOnPreferenceChangeListener(listener);
    }

    private int getThemeSummaryStringId(String theme) {
        if (null == theme) {
            return R.string.pref_ui_theme_none;
        }
        int summaryId;
        switch (theme) {
            case PreferenceActivity.THEME_LIGHT:
                summaryId = R.string.pref_ui_theme_light;
                break;
            case PreferenceActivity.THEME_DARK:
                summaryId = R.string.pref_ui_theme_dark;
                break;
            case PreferenceActivity.THEME_BLACK:
                summaryId = R.string.pref_ui_theme_black;
                break;
            case PreferenceActivity.THEME_NONE:
            default:
                summaryId = R.string.pref_ui_theme_none;
                break;
        }
        return summaryId;
    }
}
