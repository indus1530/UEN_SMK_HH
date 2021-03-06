package edu.aku.hassannaqvi.uen_smk_hh.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_smk_hh.R;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_smk_hh.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_smk_hh.core.MainApp;
import edu.aku.hassannaqvi.uen_smk_hh.databinding.ActivitySectionH102Binding;
import edu.aku.hassannaqvi.uen_smk_hh.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_smk_hh.utils.Util;

public class SectionH102Activity extends AppCompatActivity {

    ActivitySectionH102Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1_02);
        bi.setCallback(this);

        setupSkips();
        setCoronaFields();

    }

    private void setCoronaFields() {

        if (!MainApp.selectedKishMWRA.isCoronaCase()) {

            bi.fldGrpCVh1311.setVisibility(View.GONE);
            bi.h133i.setVisibility(View.GONE);
            bi.fldGrpCVh137aa.setVisibility(View.GONE);
        }
    }

    private void setupSkips() {


        //h121
        bi.h121.setOnCheckedChangeListener((group, checkedId) -> {

            Clear.clearAllFields(bi.fldGrpCVh122);
            Clear.clearAllFields(bi.fldGrpCVh123);
            Clear.clearAllFields(bi.fldGrpCVh124);
            bi.fldGrpCVh122.setVisibility(View.GONE);
            bi.fldGrpCVh123.setVisibility(View.GONE);
            bi.fldGrpCVh124.setVisibility(View.GONE);

            if (checkedId == bi.h121a.getId()) {
                bi.fldGrpCVh122.setVisibility(View.VISIBLE);
                bi.fldGrpCVh123.setVisibility(View.VISIBLE);
            } else if (checkedId == bi.h121b.getId()) {
                bi.fldGrpCVh124.setVisibility(View.VISIBLE);
            }
        });


        //h12298
        bi.h12298.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                //Clear.clearAllFields(bi.h122);
                bi.h122.setText(null);
                Clear.clearAllFields(bi.fldGrpCVh123);
                bi.h122.setVisibility(View.GONE);
                bi.fldGrpCVh123.setVisibility(View.GONE);
            } else {
                bi.h122.setVisibility(View.VISIBLE);
                bi.fldGrpCVh123.setVisibility(View.VISIBLE);
            }
        });


        //h123
        bi.h123.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h123a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVh124);
                bi.fldGrpCVh124.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVh124.setVisibility(View.VISIBLE);
            }
        });


        //h125
        bi.h125.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h125a.getId()) {
                bi.fldGrpCVh126.setVisibility(View.VISIBLE);
                bi.fldGrpCVh127.setVisibility(View.VISIBLE);
                bi.fldGrpCVh128.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129a.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129d.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129e.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh126);
                Clear.clearAllFields(bi.fldGrpCVh127);
                Clear.clearAllFields(bi.fldGrpCVh128);
                Clear.clearAllFields(bi.fldGrpCVh129a);
                Clear.clearAllFields(bi.fldGrpCVh129b);
                Clear.clearAllFields(bi.fldGrpCVh129c);
                Clear.clearAllFields(bi.fldGrpCVh129d);
                Clear.clearAllFields(bi.fldGrpCVh129e);
                bi.fldGrpCVh126.setVisibility(View.GONE);
                bi.fldGrpCVh127.setVisibility(View.GONE);
                bi.fldGrpCVh128.setVisibility(View.GONE);
                bi.fldGrpCVh129a.setVisibility(View.GONE);
                bi.fldGrpCVh129b.setVisibility(View.GONE);
                bi.fldGrpCVh129c.setVisibility(View.GONE);
                bi.fldGrpCVh129d.setVisibility(View.GONE);
                bi.fldGrpCVh129e.setVisibility(View.GONE);
            }
        });


        //h132
        bi.h132.setOnCheckedChangeListener(((radioGroup, i) -> {


            bi.fldGrpCVh133.setVisibility(View.VISIBLE);
            if (MainApp.selectedKishMWRA.isCoronaCase()) {
                bi.fldGrpCVh1321.setVisibility(View.VISIBLE);
            }

            if (i == bi.h132a.getId()) {

                bi.fldGrpCVh133.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpCVh1321);
                bi.fldGrpCVh1321.setVisibility(View.GONE);

            } else if (i == bi.h132b.getId()) {

                bi.fldGrpCVh1321.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpCVh133);
                bi.fldGrpCVh133.setVisibility(View.GONE);

            } else {

                Clear.clearAllFields(bi.fldGrpCVh1321);
                bi.fldGrpCVh1321.setVisibility(View.GONE);

                Clear.clearAllFields(bi.fldGrpCVh133);
                bi.fldGrpCVh133.setVisibility(View.GONE);
            }

        }));


        //h134
        bi.h134.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h134a.getId()) {
                bi.fldGrpCVh135.setVisibility(View.VISIBLE);
                bi.fldGrpCVh136.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh135);
                Clear.clearAllFields(bi.fldGrpCVh136);
                bi.fldGrpCVh135.setVisibility(View.GONE);
                bi.fldGrpCVh136.setVisibility(View.GONE);
            }
        });


        //h137
        bi.h137.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h137a.getId()) {
                if (MainApp.selectedKishMWRA.isCoronaCase())
                    bi.fldGrpCVh137aa.setVisibility(View.VISIBLE);
                bi.fldGrpCVh137bb.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpCVh1371);
                bi.fldGrpCVh1371.setVisibility(View.GONE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh137aa);
                Clear.clearAllFields(bi.fldGrpCVh137bb);
                bi.fldGrpCVh137aa.setVisibility(View.GONE);
                bi.fldGrpCVh137bb.setVisibility(View.GONE);
                bi.fldGrpCVh1371.setVisibility(View.VISIBLE);
            }
        });

        //h131
        bi.h131.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h131b.getId()) {
                if (MainApp.selectedKishMWRA.isCoronaCase())
                    bi.fldGrpCVh1311.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1311);
                bi.fldGrpCVh1311.setVisibility(View.GONE);

            }
        });

        //h132
        /*bi.h132.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h132a.getId()) {
                if (MainApp.selectedKishMWRA.isCoronaCase())
                    bi.fldGrpCVh1321.setVisibility(View.VISIBLE);
                bi.fldGrpCVh133.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1321);
                bi.fldGrpCVh1321.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVh133);
                bi.fldGrpCVh133.setVisibility(View.GONE);
            }
        });*/

        //h1321
        bi.h1321c.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                bi.h1321check03.setVisibility(View.VISIBLE);
            else {
                Clear.clearAllFields(bi.h1321check03);
                bi.h1321check03.setVisibility(View.GONE);
            }
        });


        bi.h1321h.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Clear.Companion.clearAllFields(bi.h1321check, !isChecked);
        });


        //h13598
        bi.h13598.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.h135check, false);
            } else {
                Clear.clearAllFields(bi.h135check, true);
            }
        });

        //h13598
        bi.h1360298.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.h13602check, false);
            } else {
                Clear.clearAllFields(bi.h13602check, true);
            }
        });

        bi.h13602j.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Clear.Companion.clearAllFields(bi.h13602check, !isChecked);

            Clear.clearAllFields(bi.fldGrpCVh13603);
            bi.fldGrpCVh13603.setVisibility(View.GONE);
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionH2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesChildColumn(ChildContract.ChildTable.COLUMN_SH1, MainApp.child.getsH1());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h121", bi.h121a.isChecked() ? "1" :
                bi.h121b.isChecked() ? "2" : "-1");

        json.put("h122", bi.h122.getText().toString().trim().isEmpty() ? "-1" : bi.h122.getText().toString());
        json.put("h12298", bi.h12298.isChecked() ? "98" : "-1");

        json.put("h123", bi.h123a.isChecked() ? "1" :
                bi.h123b.isChecked() ? "2" : "-1");

        json.put("h124", bi.h124a.isChecked() ? "1" :
                bi.h124b.isChecked() ? "2" :
                        bi.h124c.isChecked() ? "3" :
                                bi.h124d.isChecked() ? "4" :
                                        bi.h124e.isChecked() ? "5" : "-1");

        json.put("h125", bi.h125a.isChecked() ? "1" :
                bi.h125b.isChecked() ? "2" : "-1");

        json.put("h126", bi.h126a.isChecked() ? "1" :
                bi.h126b.isChecked() ? "2" :
                        bi.h126c.isChecked() ? "3" :
                                bi.h126d.isChecked() ? "4" : "-1");

        json.put("h127", bi.h127a.isChecked() ? "1" :
                bi.h127b.isChecked() ? "2" :
                        bi.h127c.isChecked() ? "3" :
                                bi.h127d.isChecked() ? "4" :
                                        bi.h127e.isChecked() ? "5" :
                                                bi.h127f.isChecked() ? "6" :
                                                        bi.h127g.isChecked() ? "7" :
                                                                bi.h127h.isChecked() ? "8" :
                                                                        bi.h127i.isChecked() ? "9" :
                                                                                bi.h127j.isChecked() ? "10" :
                                                                                        bi.h12796.isChecked() ? "96" : "-1");

        json.put("h12796x", bi.h12796x.getText().toString().trim().isEmpty() ? "-1" : bi.h12796x.getText().toString());


        json.put("h128", bi.h128a.isChecked() ? "1" :
                bi.h128b.isChecked() ? "2" :
                        bi.h128c.isChecked() ? "3" :
                                bi.h128d.isChecked() ? "4" :
                                        bi.h128e.isChecked() ? "5" : "-1");

        json.put("h129a", bi.h129aa.isChecked() ? "1" :
                bi.h129ab.isChecked() ? "2" :
                        bi.h129a98.isChecked() ? "98" : "-1");

        json.put("h129b", bi.h129ba.isChecked() ? "1" :
                bi.h129bb.isChecked() ? "2" :
                        bi.h129b98.isChecked() ? "98" : "-1");

        json.put("h129c", bi.h129ca.isChecked() ? "1" :
                bi.h129cb.isChecked() ? "2" :
                        bi.h129c98.isChecked() ? "98" : "-1");

        json.put("h129d", bi.h129da.isChecked() ? "1" :
                bi.h129db.isChecked() ? "2" :
                        bi.h129d98.isChecked() ? "98" : "-1");

        json.put("h129e", bi.h129ea.isChecked() ? "1" :
                bi.h129eb.isChecked() ? "2" :
                        bi.h129e98.isChecked() ? "98" : "-1");

        json.put("h130", bi.h130a.isChecked() ? "1" :
                bi.h130b.isChecked() ? "2" : "-1");

        json.put("h131", bi.h131a.isChecked() ? "1" :
                bi.h131b.isChecked() ? "2" : "-1");

        json.put("h13101a", bi.h1311a.isChecked() ? "1" : "-1");
        json.put("h13101b", bi.h1311b.isChecked() ? "2" : "-1");
        json.put("h13101c", bi.h1311c.isChecked() ? "3" : "-1");
        json.put("h13101d", bi.h1311d.isChecked() ? "4" : "-1");
        json.put("h13101e", bi.h1311e.isChecked() ? "5" : "-1");
        json.put("h13101f", bi.h1311f.isChecked() ? "6" : "-1");
        json.put("h13101g", bi.h1311g.isChecked() ? "7" : "-1");

        json.put("h132", bi.h132a.isChecked() ? "1"
                : bi.h132b.isChecked() ? "2"
                : bi.h132c.isChecked() ? "3"
                : "-1");

        json.put("h13201a", bi.h1321a.isChecked() ? "1" : "-1");
        json.put("h13201b", bi.h1321b.isChecked() ? "2" : "-1");
        json.put("h13201c", bi.h1321c.isChecked() ? "3" : "-1");
        json.put("h13201d", bi.h1321d.isChecked() ? "4" : "-1");
        json.put("h13201e", bi.h1321e.isChecked() ? "5" : "-1");
        json.put("h13201f", bi.h1321f.isChecked() ? "6" : "-1");
        json.put("h13201g", bi.h1321g.isChecked() ? "7" : "-1");
        json.put("h13201h", bi.h1321h.isChecked() ? "8" : "-1");

        json.put("h133a", bi.h133a.isChecked() ? "1" : "-1");
        json.put("h133b", bi.h133b.isChecked() ? "2" : "-1");
        json.put("h133c", bi.h133c.isChecked() ? "3" : "-1");
        json.put("h133d", bi.h133d.isChecked() ? "4" : "-1");
        json.put("h133e", bi.h133e.isChecked() ? "5" : "-1");
        json.put("h133f", bi.h133f.isChecked() ? "6" : "-1");
        json.put("h133g", bi.h133g.isChecked() ? "7" : "-1");
        json.put("h133h", bi.h133h.isChecked() ? "8" : "-1");
        json.put("h133i", bi.h133i.isChecked() ? "9" : "-1");

        json.put("h134", bi.h134a.isChecked() ? "1"
                : bi.h134b.isChecked() ? "2"
                : "-1");

        json.put("h135a", bi.h135a.isChecked() ? "1" : "-1");
        json.put("h135b", bi.h135b.isChecked() ? "2" : "-1");
        json.put("h135c", bi.h135c.isChecked() ? "3" : "-1");
        json.put("h135d", bi.h135d.isChecked() ? "4" : "-1");
        json.put("h135e", bi.h135e.isChecked() ? "5" : "-1");
        json.put("h135f", bi.h135f.isChecked() ? "6" : "-1");
        json.put("h135g", bi.h135g.isChecked() ? "7" : "-1");
        json.put("h135h", bi.h135h.isChecked() ? "8" : "-1");
        json.put("h135i", bi.h135i.isChecked() ? "9" : "-1");
        json.put("h13598", bi.h13598.isChecked() ? "98" : "-1");

        json.put("h136a", bi.h136a.isChecked() ? "1" : "-1");
        json.put("h136b", bi.h136b.isChecked() ? "2" : "-1");
        json.put("h136c", bi.h136c.isChecked() ? "3" : "-1");
        json.put("h136d", bi.h136d.isChecked() ? "4" : "-1");
        json.put("h136e", bi.h136e.isChecked() ? "5" : "-1");
        json.put("h136f", bi.h136f.isChecked() ? "6" : "-1");

        json.put("h13601", bi.h13601a.isChecked() ? "1"
                : bi.h13601b.isChecked() ? "2"
                : "-1");

        json.put("h13602a", bi.h13602a.isChecked() ? "1" : "-1");
        json.put("h13602b", bi.h13602b.isChecked() ? "2" : "-1");
        json.put("h13602c", bi.h13602c.isChecked() ? "3" : "-1");
        json.put("h13602d", bi.h13602d.isChecked() ? "4" : "-1");
        json.put("h13602e", bi.h13602e.isChecked() ? "5" : "-1");
        json.put("h13602f", bi.h13602f.isChecked() ? "6" : "-1");
        json.put("h13602g", bi.h13602g.isChecked() ? "7" : "-1");
        json.put("h13602h", bi.h13602h.isChecked() ? "8" : "-1");
        json.put("h13602i", bi.h13602i.isChecked() ? "9" : "-1");
        json.put("h13602j", bi.h13602j.isChecked() ? "10" : "-1");
        json.put("h1360298", bi.h1360298.isChecked() ? "98" : "-1");

        json.put("h13603", bi.h13603a.isChecked() ? "1" :
                bi.h13603b.isChecked() ? "2" : "-1");

        json.put("h137", bi.h137a.isChecked() ? "1" :
                bi.h137b.isChecked() ? "2" : "-1");


        json.put("h13701", bi.h137aaa.isChecked() ? "1" :
                bi.h137aab.isChecked() ? "2" :
                        bi.h137aac.isChecked() ? "3" :
                                bi.h137aad.isChecked() ? "4" :
                                        bi.h137aae.isChecked() ? "5" : "-1");

        json.put("h13702", bi.h137bba.isChecked() ? "1" :
                bi.h137bbb.isChecked() ? "2" :
                        bi.h137bbc.isChecked() ? "3" :
                                bi.h137bbd.isChecked() ? "4" :
                                        bi.h137bbe.isChecked() ? "5" :
                                                bi.h137bbf.isChecked() ? "6" :
                                                        bi.h137bbg.isChecked() ? "7" :
                                                                bi.h137bb96.isChecked() ? "96" : "-1");

        json.put("h1370296x", bi.h137bb96x.getText().toString().trim().isEmpty() ? "-1" : bi.h137bb96x.getText().toString());

        json.put("h13703", bi.h1371a.isChecked() ? "1" :
                bi.h1371b.isChecked() ? "2" :
                        bi.h1371c.isChecked() ? "3" :
                                bi.h1371d.isChecked() ? "4" :
                                        bi.h1371e.isChecked() ? "5" :
                                                bi.h1371f.isChecked() ? "6" :
                                                        bi.h1371g.isChecked() ? "7"
                                                                : "-1");

        json.put("h12500", bi.h12500a.isChecked() ? "1"
                : bi.h12500b.isChecked() ? "2"
                : "-1");

        json.put("h12501", bi.h12501a.isChecked() ? "1"
                : bi.h12501b.isChecked() ? "2"
                : "-1");

        try {

            JSONObject s4_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.child.getsH1()), json);
            MainApp.child.setsH1(String.valueOf(s4_merge));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionH2);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
