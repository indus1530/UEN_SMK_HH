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
import edu.aku.hassannaqvi.uen_smk_hh.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_smk_hh.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_smk_hh.core.MainApp;
import edu.aku.hassannaqvi.uen_smk_hh.databinding.ActivitySectionF02Binding;
import edu.aku.hassannaqvi.uen_smk_hh.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_smk_hh.utils.Util;

public class SectionF02Activity extends AppCompatActivity {

    ActivitySectionF02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f02);
        bi.setCallback(this);

        setUIComponent();
        setCoronaFields();
    }

    private void setCoronaFields() {

        if (!MainApp.selectedKishMWRA.isCoronaCase()) {

            bi.fldGrpCVf1211.setVisibility(View.GONE);
            bi.fldGrpCVf1212.setVisibility(View.GONE);

            bi.f123h.setVisibility(View.GONE);

            bi.f130j.setVisibility(View.GONE);
            bi.f130k.setVisibility(View.GONE);
            bi.f130l.setVisibility(View.GONE);
            bi.f130m.setVisibility(View.GONE);
            bi.f130n.setVisibility(View.GONE);
            bi.f130o.setVisibility(View.GONE);

            bi.f134h.setVisibility(View.GONE);
        }
    }

    private void setUIComponent() {


        bi.f121.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.f121a.getId()) {

                Clear.clearAllFields(bi.fldGrpCVf1211);
                Clear.clearAllFields(bi.fldGrp2223);
            }

        }));


        bi.f1211.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.f1211b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf1212);
            }

        }));

        bi.f124.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.f124a.getId()) {
                Clear.clearAllFields(bi.fldGrp2531);
            }
        }));

        //f128h
        bi.f128h.setOnCheckedChangeListener((compoundButton, b) -> {

            if (b) {
                Clear.clearAllFields(bi.fldGrp2532);
            }

        });

        bi.f1212c.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (!isChecked) {

                Clear.clearAllFields(bi.f1212d);
                Clear.clearAllFields(bi.f1212e);
                Clear.clearAllFields(bi.f1212f);
                Clear.clearAllFields(bi.f1212g);

                bi.f1212d.setVisibility(View.GONE);
                bi.f1212e.setVisibility(View.GONE);
                bi.f1212f.setVisibility(View.GONE);
                bi.f1212g.setVisibility(View.GONE);

            } else {

                bi.f1212d.setVisibility(View.VISIBLE);
                bi.f1212e.setVisibility(View.VISIBLE);
                bi.f1212f.setVisibility(View.VISIBLE);
                bi.f1212g.setVisibility(View.VISIBLE);
            }

        });

        //g1251
        bi.f1212c.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {

                Clear.clearAllFields(bi.f1212d);
                Clear.clearAllFields(bi.f1212e);
                Clear.clearAllFields(bi.f1212f);
                Clear.clearAllFields(bi.f1212g);

                bi.f1212d.setVisibility(View.GONE);
                bi.f1212e.setVisibility(View.GONE);
                bi.f1212f.setVisibility(View.GONE);
                bi.f1212g.setVisibility(View.GONE);

            } else {

                bi.f1212d.setVisibility(View.VISIBLE);
                bi.f1212e.setVisibility(View.VISIBLE);
                bi.f1212f.setVisibility(View.VISIBLE);
                bi.f1212g.setVisibility(View.VISIBLE);
            }
        });

        bi.f1212h.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Clear.Companion.clearAllFields(bi.f1212check, !isChecked);
        });

        bi.f129.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.f129a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf130);
            } else if (i == bi.f129b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf131);
            }
        }));
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
                startActivity(new Intent(this, SectionGActivity.class));
            }

        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SF, MainApp.kish.getsF());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("f121", bi.f121a.isChecked() ? "1"
                : bi.f121b.isChecked() ? "2"
                : "-1");

        f1.put("f12101", bi.f1211a.isChecked() ? "1"
                : bi.f1211b.isChecked() ? "2"
                : bi.f1211c.isChecked() ? "3"
                : "-1");

        f1.put("f12102a", bi.f1212a.isChecked() ? "1" : "-1");
        f1.put("f12102b", bi.f1212b.isChecked() ? "2" : "-1");
        f1.put("f12102c", bi.f1212c.isChecked() ? "3" : "-1");
        f1.put("f12102d", bi.f1212d.isChecked() ? "4" : "-1");
        f1.put("f12102e", bi.f1212e.isChecked() ? "5" : "-1");
        f1.put("f12102f", bi.f1212f.isChecked() ? "6" : "-1");
        f1.put("f12102g", bi.f1212g.isChecked() ? "7" : "-1");
        f1.put("f12102h", bi.f1212h.isChecked() ? "8" : "-1");

        f1.put("f122", bi.f122.getText().toString().trim().isEmpty() ? "-1" : bi.f122.getText().toString());

        f1.put("f123a", bi.f123a.isChecked() ? "1" : "-1");
        f1.put("f123b", bi.f123b.isChecked() ? "2" : "-1");
        f1.put("f123c", bi.f123c.isChecked() ? "3" : "-1");
        f1.put("f123d", bi.f123d.isChecked() ? "4" : "-1");
        f1.put("f123e", bi.f123e.isChecked() ? "5" : "-1");
        f1.put("f123f", bi.f123f.isChecked() ? "6" : "-1");
        f1.put("f123g", bi.f123g.isChecked() ? "7" : "-1");
        f1.put("f123h", bi.f123h.isChecked() ? "8" : "-1");
        f1.put("f123i", bi.f123i.isChecked() ? "9" : "-1");
        f1.put("f12396", bi.f12396.isChecked() ? "96" : "-1");
        f1.put("f12396x", bi.f12396x.getText().toString().trim().isEmpty() ? "-1" : bi.f12396x.getText().toString());

        f1.put("f124", bi.f124a.isChecked() ? "1" :
                bi.f124b.isChecked() ? "2" : "-1");

        f1.put("f125a", bi.f125a.isChecked() ? "1" : "-1");
        f1.put("f125b", bi.f125b.isChecked() ? "2" : "-1");
        f1.put("f125c", bi.f125c.isChecked() ? "3" : "-1");
        f1.put("f125d", bi.f125d.isChecked() ? "4" : "-1");
        f1.put("f125e", bi.f125e.isChecked() ? "5" : "-1");
        f1.put("f125f", bi.f125f.isChecked() ? "6" : "-1");
        f1.put("f125g", bi.f125g.isChecked() ? "7" : "-1");

        f1.put("f126a", bi.f126a.isChecked() ? "1" : "-1");
        f1.put("f126b", bi.f126b.isChecked() ? "2" : "-1");
        f1.put("f126c", bi.f126c.isChecked() ? "3" : "-1");
        f1.put("f126d", bi.f126d.isChecked() ? "4" : "-1");
        f1.put("f126e", bi.f126e.isChecked() ? "5" : "-1");
        f1.put("f126f", bi.f126f.isChecked() ? "6" : "-1");
        f1.put("f126g", bi.f126g.isChecked() ? "7" : "-1");

        f1.put("f127", bi.f127a.isChecked() ? "1" :
                bi.f127b.isChecked() ? "2" :
                        bi.f127c.isChecked() ? "3" :
                                bi.f127d.isChecked() ? "4" :
                                        bi.f127e.isChecked() ? "5" :
                                                bi.f127f.isChecked() ? "6" :
                                                        bi.f127g.isChecked() ? "7" :
                                                                bi.f127h.isChecked() ? "8" :
                                                                        bi.f127i.isChecked() ? "9" :
                                                                                bi.f127j.isChecked() ? "10" :
                                                                                        bi.f127k.isChecked() ? "11" :
                                                                                                "-1");

        f1.put("f128a", bi.f128a.isChecked() ? "1" : "-1");
        f1.put("f128b", bi.f128b.isChecked() ? "2" : "-1");
        f1.put("f128c", bi.f128c.isChecked() ? "3" : "-1");
        f1.put("f128d", bi.f128d.isChecked() ? "4" : "-1");
        f1.put("f128e", bi.f128e.isChecked() ? "5" : "-1");
        f1.put("f128f", bi.f128f.isChecked() ? "6" : "-1");
        f1.put("f128g", bi.f128g.isChecked() ? "7" : "-1");
        f1.put("f128h", bi.f128h.isChecked() ? "8" : "-1");

        f1.put("f129", bi.f129a.isChecked() ? "1" :
                bi.f129b.isChecked() ? "2" : "-1");

        f1.put("f130a", bi.f130a.isChecked() ? "1" : "-1");
        f1.put("f130b", bi.f130b.isChecked() ? "2" : "-1");
        f1.put("f130c", bi.f130c.isChecked() ? "3" : "-1");
        f1.put("f130d", bi.f130d.isChecked() ? "4" : "-1");
        f1.put("f130e", bi.f130e.isChecked() ? "5" : "-1");
        f1.put("f130f", bi.f130f.isChecked() ? "6" : "-1");
        f1.put("f130g", bi.f130g.isChecked() ? "7" : "-1");
        f1.put("f130h", bi.f130h.isChecked() ? "8" : "-1");
        f1.put("f130i", bi.f130i.isChecked() ? "9" : "-1");
        f1.put("f130j", bi.f130j.isChecked() ? "10" : "-1");
        f1.put("f130k", bi.f130k.isChecked() ? "11" : "-1");
        f1.put("f130l", bi.f130l.isChecked() ? "12" : "-1");
        f1.put("f130m", bi.f130m.isChecked() ? "13" : "-1");
        f1.put("f130n", bi.f130n.isChecked() ? "14" : "-1");
        f1.put("f130o", bi.f130o.isChecked() ? "15" : "-1");

        f1.put("f131", bi.f131a.isChecked() ? "1" :
                bi.f131b.isChecked() ? "2" :
                        bi.f131c.isChecked() ? "3" :
                                bi.f131d.isChecked() ? "4" :
                                        bi.f131e.isChecked() ? "5" :
                                                bi.f131f.isChecked() ? "6" :
                                                        bi.f131g.isChecked() ? "7" :
                                                                bi.f131h.isChecked() ? "8" :
                                                                        bi.f131i.isChecked() ? "9" :
                                                                                bi.f131j.isChecked() ? "10" : "-1");

        f1.put("f12801", bi.f12801a.isChecked() ? "1"
                : bi.f12801b.isChecked() ? "2"
                : "-1");

        f1.put("f132", bi.f132a.isChecked() ? "1"
                : bi.f132b.isChecked() ? "2"
                : bi.f132c.isChecked() ? "3"
                : "-1");

        f1.put("f13200", bi.f13200a.isChecked() ? "1"
                : bi.f13200b.isChecked() ? "2"
                : "-1");

        f1.put("f13201", bi.f13201a.isChecked() ? "1"
                : bi.f13201b.isChecked() ? "2"
                : "-1");

        f1.put("f133", bi.f133a.isChecked() ? "1"
                : bi.f133b.isChecked() ? "2"
                : bi.f133c.isChecked() ? "3"
                : "-1");

        f1.put("f13300", bi.f13300a.isChecked() ? "1"
                : bi.f13300b.isChecked() ? "2"
                : "-1");

        f1.put("f13301", bi.f13301a.isChecked() ? "1"
                : bi.f13301b.isChecked() ? "2"
                : "-1");

        f1.put("f134a", bi.f134a.isChecked() ? "1" : "-1");
        f1.put("f134b", bi.f134b.isChecked() ? "2" : "-1");
        f1.put("f134c", bi.f134c.isChecked() ? "3" : "-1");
        f1.put("f134d", bi.f134d.isChecked() ? "4" : "-1");
        f1.put("f134e", bi.f134e.isChecked() ? "5" : "-1");
        f1.put("f134f", bi.f134f.isChecked() ? "6" : "-1");
        f1.put("f134g", bi.f134g.isChecked() ? "7" : "-1");
        f1.put("f134h", bi.f134h.isChecked() ? "8" : "-1");

        try {

            JSONObject s4_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.kish.getsF()), f1);
            MainApp.kish.setsF(String.valueOf(s4_merge));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionf02);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
