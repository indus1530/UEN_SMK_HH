package edu.aku.hassannaqvi.uen_smk_hh.utils;

import edu.aku.hassannaqvi.uen_smk_hh.contracts.AdolscentContract.SingleAdolscent;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.BLRandomContract.RandomHH;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.DistrictContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.KishMWRAContract.SingleKishMWRA;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.MWRA_PREContract.SingleMWRAPRE;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.VersionAppContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "smk_bl.db";
    public static final String DB_NAME = "smk_bl.db";
    public static final String PROJECT_NAME = "DMU-SMK/BL";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_CLUSTERCODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HHNO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMTYPE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LUID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SINFO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SM + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SN + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersContract.UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.UsersTable.ROW_USERNAME + " TEXT,"
            + UsersContract.UsersTable.ROW_PASSWORD + " TEXT,"
            + UsersContract.UsersTable.DIST_ID + " TEXT"
            + " );";

    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";

    public static final String SQL_CREATE_BL_RANDOM = "CREATE TABLE " + RandomHH.TABLE_NAME + "("
            + RandomHH.COLUMN_ID + " TEXT,"
            + RandomHH.COLUMN_ENUM_BLOCK_CODE + " TEXT,"
            + RandomHH.COLUMN_LUID + " TEXT,"
            + RandomHH.COLUMN_HH + " TEXT,"
            + RandomHH.COLUMN_STRUCTURE_NO + " TEXT,"
            + RandomHH.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + RandomHH.COLUMN_HH_HEAD + " TEXT,"
            + RandomHH.COLUMN_CONTACT + " TEXT,"
            + RandomHH.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + RandomHH.COLUMN_RANDOMDT + " TEXT,"
            + RandomHH.COLUMN_SNO_HH + " TEXT );";

    public static final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + EnumBlockContract.EnumBlockTable.TABLE_NAME + " (" +
            EnumBlockContract.EnumBlockTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EnumBlockContract.EnumBlockTable.COLUMN_DIST_ID + " TEXT, " +
            EnumBlockContract.EnumBlockTable.COLUMN_GEO_AREA + " TEXT, " +
            EnumBlockContract.EnumBlockTable.COLUMN_CLUSTER_AREA + " TEXT " +
            ");";

    public static final String SQL_CREATE_KISH_TABLE = "CREATE TABLE " + SingleKishMWRA.TABLE_NAME + "("
            + SingleKishMWRA._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleKishMWRA.COLUMN_UID + " TEXT,"
            + SingleKishMWRA.COLUMN__UUID + " TEXT,"
            + SingleKishMWRA.COLUMN_DEVICEID + " TEXT,"
            + SingleKishMWRA.COLUMN_FORMDATE + " TEXT,"
            + SingleKishMWRA.COLUMN_USER + " TEXT,"
            + SingleKishMWRA.COLUMN_SF + " TEXT,"
            + SingleKishMWRA.COLUMN_SG + " TEXT,"
            + SingleKishMWRA.COLUMN_SH2 + " TEXT,"
            + SingleKishMWRA.COLUMN_SK + " TEXT,"
            + SingleKishMWRA.COLUMN_SUN + " TEXT,"
            + SingleKishMWRA.COLUMN_SL + " TEXT,"
            + SingleKishMWRA.COLUMN_DEVICETAGID + " TEXT,"
            + SingleKishMWRA.COLUMN_SYNCED + " TEXT,"
            + SingleKishMWRA.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_MWRA_TABLE = "CREATE TABLE " + MWRATable.TABLE_NAME + "("
            + MWRATable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MWRATable.COLUMN_UID + " TEXT,"
            + MWRATable.COLUMN_UUID + " TEXT,"
            + MWRATable.COLUMN_FORMDATE + " TEXT,"
            + MWRATable.COLUMN_DEVICEID + " TEXT,"
            + MWRATable.COLUMN_USER + " TEXT,"
            + MWRATable.COLUMN_SE1 + " TEXT,"
            + MWRATable.COLUMN_DEVICETAGID + " TEXT,"
            + MWRATable.COLUMN_SYNCED + " TEXT,"
            + MWRATable.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_MWRAPRE_TABLE = "CREATE TABLE " + SingleMWRAPRE.TABLE_NAME + "("
            + SingleMWRAPRE._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleMWRAPRE.COLUMN_UID + " TEXT,"
            + SingleMWRAPRE.COLUMN__UUID + " TEXT,"
            + SingleMWRAPRE.COLUMN_FORMDATE + " TEXT,"
            + SingleMWRAPRE.COLUMN_DEVICEID + " TEXT,"
            + SingleMWRAPRE.COLUMN_USER + " TEXT,"
            + SingleMWRAPRE.COLUMN_SE2 + " TEXT,"
            + SingleMWRAPRE.COLUMN_DEVICETAGID + " TEXT,"
            + SingleMWRAPRE.COLUMN_SYNCED + " TEXT,"
            + SingleMWRAPRE.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_ADOLSCENT_TABLE = "CREATE TABLE " + SingleAdolscent.TABLE_NAME + "("
            + SingleAdolscent._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleAdolscent.COLUMN_UID + " TEXT,"
            + SingleAdolscent.COLUMN__UUID + " TEXT,"
            + SingleAdolscent.COLUMN_DEVICEID + " TEXT,"
            + SingleAdolscent.COLUMN_FORMDATE + " TEXT,"
            + SingleAdolscent.COLUMN_USER + " TEXT,"
            + SingleAdolscent.COLUMN_SAH1 + " TEXT,"
            + SingleAdolscent.COLUMN_SAH2 + " TEXT,"
            + SingleAdolscent.COLUMN_SAH3 + " TEXT,"
            + SingleAdolscent.COLUMN_DEVICETAGID + " TEXT,"
            + SingleAdolscent.COLUMN_SYNCED + " TEXT,"
            + SingleAdolscent.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_CHILD_TABLE = "CREATE TABLE " + ChildContract.ChildTable.TABLE_NAME + "("
            + ChildContract.ChildTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildContract.ChildTable.COLUMN_UID + " TEXT,"
            + ChildContract.ChildTable.COLUMN__UUID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_FORMDATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_USER + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SH1 + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SJ + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_FAMILY_MEMBERS = "CREATE TABLE " + FamilyMembersContract.SingleMember.TABLE_NAME + "("
            + FamilyMembersContract.SingleMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FamilyMembersContract.SingleMember.COLUMN_UID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_UUID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_FORMDATE + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_CLUSTERNO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_HHNO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SERIAL_NO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_NAME + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_RELATION_HH + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_AGE + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MONTH_FM + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_DAY_FM + " TEXT," +
            FamilyMembersContract.SingleMember.AGE_IN_DAYS + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MOTHER_NAME + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MOTHER_SERIAL + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_GENDER + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MARITAL + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SD + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SYNCED + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SYNCED_DATE + " TEXT"
            + ");";

    public static final String SQL_CREATE_DISTRICTS = "CREATE TABLE " + DistrictContract.DistrictTable.TABLE_NAME + "("
            + DistrictContract.DistrictTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DistrictContract.DistrictTable.COLUMN_DIST_ID + " TEXT,"
            + DistrictContract.DistrictTable.COLUMN_DIST_NAME + " TEXT,"
            + DistrictContract.DistrictTable.COLUMN_PROVINCE_NAME + " TEXT );";


}
