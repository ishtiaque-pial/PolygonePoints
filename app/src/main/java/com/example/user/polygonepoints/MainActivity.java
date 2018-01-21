package com.example.user.polygonepoints;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Place> latLngArrayList = new ArrayList<>();
    ArrayList<Place> dummyLatLngArrayList = new ArrayList<>();
    double lat = 23.837188;
    double lng =  90.362740;

    String a ="23.79957\t90.412951\n" +
            "23.799097\t90.413875\n" +
            "23.798\t90.414264\n" +
            "23.796611\t90.413837\n" +
            "23.796296\t90.414628\n" +
            "23.796313\t90.415872\n" +
            "23.79608\t90.417332\n" +
            "23.795076\t90.417639\n" +
            "23.794696\t90.418762\n" +
            "23.793471\t90.419897\n" +
            "23.792297\t90.420318\n" +
            "23.791463\t90.420497\n" +
            "23.791141\t90.421256\n" +
            "23.790739\t90.422628\n" +
            "23.789314\t90.422264\n" +
            "23.788655\t90.422423\n" +
            "23.787551\t90.422309\n" +
            "23.786058\t90.421553\n" +
            "23.783257\t90.421346\n" +
            "23.781833\t90.420772\n" +
            "23.780829\t90.420899\n" +
            "23.780911\t90.421282\n" +
            "23.780519\t90.421493\n" +
            "23.780353\t90.421035\n" +
            "23.779086\t90.42101\n" +
            "23.779127\t90.420919\n";
    //23.837188, 90.362740
    LatLng latLng = new LatLng(lat, lng);
    double PREVIOUS_LATIUDE;
    double PREVIOUS_LONGITUDE;
    float Distance = 0;
    int count =0;
    int firstIndex =0;
    int midleIndex = 0;
    int lastIndex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String newline = System.getProperty("line.separator");
        for (int i=0;i<a.length();i++) {
            if (a.charAt(i)=='\n') {
                String latlng = a.substring(firstIndex,i);
                for (int j=0;j<latlng.length();j++){
                    if (latlng.charAt(j)=='\t'||latlng.charAt(j)==',') {
                        String lat = latlng.substring(0,j);
                        String lng = latlng.substring(j+1,latlng.length());
                        latLngArrayList.add(new Place(""+count,new LatLng(Double.parseDouble(lat),Double.parseDouble(lng))));
                        Log.e("Latlng",""+lat+","+lng);
                       // break;
                        count++;
                        break;

                    }
                }
                firstIndex = i+1;
            }
            if (i==a.length()-1) {
                String latlng = a.substring(firstIndex,i+1);
                for (int j=0;j<latlng.length();j++){
                    if (latlng.charAt(j)=='\t'||latlng.charAt(j)==',') {
                        String lat = latlng.substring(0,j);
                        String lng = latlng.substring(j+1,latlng.length());
                        latLngArrayList.add(new Place(""+count,new LatLng(Double.parseDouble(lat),Double.parseDouble(lng))));
                        Log.e("Latlng",""+lat+","+lng);
                        // break;
                        count++;
                        break;

                    }
                }
            }
        }
        Log.e("count",""+count);
//
//        Place latLng1   = new Place("A",new LatLng(23.790625,90.415623));
////        Place latLng2   = new Place("2",new LatLng(23.8687483,      90.4529433));
////        Place latLng3   = new Place("3",new LatLng(23.8687817,      90.4529667));
////        Place latLng4   = new Place("4",new LatLng(23.8688317,      90.45299));
////        Place latLng5   = new Place("5",new LatLng(23.8700033,      90.451815));
////        Place latLng6   = new Place("6",new LatLng(23.86883,        90.4527783));
////        Place latLng7   = new Place("7",new LatLng(23.86884,        90.4527817));
////        Place latLng8   = new Place("8",new LatLng(23.868845,       90.4527883));
////        Place latLng9   = new Place("9",new LatLng(23.8688517,      90.4527967));
////        Place latLng10  = new Place("10",new LatLng(23.8688817,      90.45283));
////        Place latLng12  = new Place("11",new LatLng(23.8688967,      90.452825));
////        Place latLng13  = new Place("12",new LatLng(23.8689117,      90.4528167));
////        Place latLng14  = new Place("13",new LatLng(23.8689067,      90.4528283));
////        Place latLng15  = new Place("14",new LatLng(23.8689033,      90.4527917));
////        Place latLng16  = new Place("15",new LatLng(23.8689133,      90.4527817));
////        Place latLng17  = new Place("16",new LatLng(23.86891,        90.4527817));
////        Place latLng18  = new Place("17",new LatLng(23.8689017,      90.4527917));
////        Place latLng19  = new Place("18",new LatLng(23.8688917,      90.4528067));
////        Place latLng20  = new Place("19",new LatLng(23.868865,       90.4528267));
////        Place latLng21  = new Place("20",new LatLng(23.868865,       90.4528383));
////        Place latLng22  = new Place("21",new LatLng(23.8688617,      90.4528533));
////        Place latLng23  = new Place("22",new LatLng(23.8688567,      90.45285));
////        Place latLng24  = new Place("23",new LatLng(23.868835,       90.4528567));
////        Place latLng25  = new Place("24",new LatLng(23.8688367,      90.4528517));
////        Place latLng26  = new Place("25",new LatLng(23.8688417,      90.4528317));
////        Place latLng27  = new Place("26",new LatLng(23.86884,        90.4528317));
////        Place latLng28  = new Place("27",new LatLng(23.8688417,      90.4528333));
////        Place latLng29  = new Place("28",new LatLng(23.8688367,      90.4528417));
////        Place latLng30  = new Place("30",new LatLng(23.8688467,      90.4528717));
////        Place latLng31  = new Place("31",new LatLng(23.8688567,      90.4528767));
////        Place latLng32  = new Place("32",new LatLng(23.8688767,      90.452885));
////        Place latLng33  = new Place("33",new LatLng(23.8688833,      90.4528917));
////        Place latLng34  = new Place("34",new LatLng(23.8688783,      90.452905));
////        Place latLng35  = new Place("35",new LatLng(23.8688833,      90.45294));
////        Place latLng36  = new Place("36",new LatLng(23.8688667,      90.4529783));
////        Place latLng37  = new Place("37",new LatLng(23.8688317,      90.4530167));
////        Place latLng38  = new Place("38",new LatLng(23.8688067,      90.453055));
////        Place latLng39  = new Place("39",new LatLng(23.8687617,      90.4531333));
////        Place latLng40  = new Place("40",new LatLng(23.868755,       90.4531567));
////        Place latLng41  = new Place("41",new LatLng(23.8687417,      90.4531667));
////        Place latLng42  = new Place("42",new LatLng(23.8687417,      90.4531617));
////        Place latLng43  = new Place("43",new LatLng(23.8687383,      90.4531017));
////        Place latLng44  = new Place("44",new LatLng(23.8687467,      90.4530617));
////        Place latLng45  = new Place("45",new LatLng(23.8687617,      90.45305));
////        Place latLng46  = new Place("46",new LatLng(23.8687483,      90.45309));
////        Place latLng47  = new Place("47",new LatLng(23.8687383,      90.4530917));
////        Place latLng48  = new Place("48",new LatLng(23.8687367,      90.4530833));
////        Place latLng49  = new Place("49",new LatLng(23.8687383,      90.45306));
////        Place latLng50  = new Place("50",new LatLng(23.8687383,      90.4530617));
////        Place latLng51  = new Place("51",new LatLng(23.8687233,      90.4530333));
////        Place latLng52  = new Place("52",new LatLng(23.8687167,      90.4530133));
////        Place latLng53  = new Place("53",new LatLng(23.8687017,      90.4529733));
////        Place latLng54  = new Place("54",new LatLng(23.8687017,      90.4529517));
////        Place latLng55  = new Place("55",new LatLng(23.8687017,      90.4529317));
////        Place latLng56  = new Place("56",new LatLng(23.8687033,      90.4529267));
////        Place latLng57  = new Place("57",new LatLng(23.8686933,      90.452895));
////        Place latLng58  = new Place("58",new LatLng(23.86869,        90.4528733));
////        Place latLng59  = new Place("59",new LatLng(23.8686983,      90.4528417));
////        Place latLng60  = new Place("60",new LatLng(23.868695,       90.4528133));
////        Place latLng61  = new Place("61",new LatLng(23.868705,       90.4527883));
////        Place latLng62  = new Place("62",new LatLng(23.8687317,      90.452835));
////        Place latLng63  = new Place("63",new LatLng(23.8687583,      90.4528483));
////        Place latLng64  = new Place("64",new LatLng(23.868755,       90.4528683));
////        Place latLng65  = new Place("65",new LatLng(23.8687567,      90.45286));
////        Place latLng66  = new Place("66",new LatLng(23.868765,       90.452895));
////        Place latLng67  = new Place("67",new LatLng(23.8687767,      90.4529));
////        Place latLng68  = new Place("68",new LatLng(23.8687917,      90.4529117));
////        Place latLng69  = new Place("69",new LatLng(23.86879,        90.4529317));
////        Place latLng70  = new Place("70",new LatLng(23.868785,       90.4529167));
////        Place latLng71  = new Place("71",new LatLng(23.8687783,      90.45293));
////        Place latLng72  = new Place("72",new LatLng(23.86878,        90.4529283));
////        Place latLng73  = new Place("73",new LatLng(23.86877,        90.4529117));
////        Place latLng74  = new Place("74",new LatLng(23.8687483,      90.4529033));
////        Place latLng75  = new Place("75",new LatLng(23.8687383,      90.4529));
////        Place latLng76  = new Place("76",new LatLng(23.8687367,      90.4529217));
////        Place latLng77  = new Place("77",new LatLng(23.868745,       90.4529233));
////        Place latLng78  = new Place("78",new LatLng(23.8687483,      90.4529333));
////        Place latLng79  = new Place("79",new LatLng(23.8687333,      90.4529433));
////        Place latLng80  = new Place("80",new LatLng(23.868735,       90.4529417));
////        Place latLng81  = new Place("81",new LatLng(23.8687533,      90.4529667));
////        Place latLng82  = new Place("82",new LatLng(23.8687583,      90.4529667));
////        Place latLng83  = new Place("83",new LatLng(23.8687617,      90.4529483));
////        Place latLng84  = new Place("84",new LatLng(23.86876,        90.452945));
////        Place latLng85  = new Place("85",new LatLng(23.8687567,      90.4529467));
////        Place latLng86  = new Place("86",new LatLng(23.868765,       90.45296));
////        Place latLng87  = new Place("87",new LatLng(23.8687567,      90.4530083));
////        Place latLng88  = new Place("88",new LatLng(23.8687617,      90.4530033));
////        Place latLng89  = new Place("89",new LatLng(23.8687633,      90.4529967));
////        Place latLng90  = new Place("90",new LatLng(23.8687817,      90.4529983));
////        Place latLng91  = new Place("91",new LatLng(23.8687917,      90.4529783));
////        Place latLng92  = new Place("92",new LatLng(23.8687583,      90.452985));
////        Place latLng93  = new Place("93",new LatLng(23.8687533,      90.4530083));
////        Place latLng94  = new Place("94",new LatLng(23.8687517,      90.4530017));
////        Place latLng95  = new Place("95",new LatLng(23.86878,        90.4530217));
////        Place latLng96  = new Place("96",new LatLng(23.8687683,      90.4529783));
////        Place latLng97  = new Place("97",new LatLng(23.8687817,      90.452985));
////        Place latLng98  = new Place("98",new LatLng(23.8687733,      90.4530183));
////        Place latLng99  = new Place("99",new LatLng(23.86878,        90.453045));
////        Place latLng100 = new Place("100",new LatLng(23.868917,       90.45305));
////        Place latLng101 = new Place("101",new LatLng(23.86881,        90.4530633));
////        Place latLng102 = new Place("102",new LatLng(23.8688067,      90.4530667));
////        Place latLng103 = new Place("103",new LatLng(23.86882,        90.453135));
////        Place latLng104 = new Place("104",new LatLng(23.8688233,      90.453145));
////        Place latLng105 = new Place("105",new LatLng(23.86883,        90.4531467));
////        Place latLng106 = new Place("106",new LatLng(23.8688567,      90.4531733));
////        Place latLng107 = new Place("107",new LatLng(23.8688617,      90.45318));
////        Place latLng108 = new Place("108",new LatLng(23.8688683,      90.45323));
////        Place latLng109 = new Place("109",new LatLng(23.8688683,      90.453235));
////        Place latLng110 = new Place("110",new LatLng(23.8688517,      90.4531433));
////        Place latLng111 = new Place("111",new LatLng(23.8688433,      90.45313));
////        Place latLng112 = new Place("112",new LatLng(23.8688383,      90.4530917));
////        Place latLng113 = new Place("113",new LatLng(23.868835,       90.4530767));
////        Place latLng114 = new Place("114",new LatLng(23.8688367,      90.4530667));
////        Place latLng115 = new Place("115",new LatLng(23.8688333,      90.45305));
////        Place latLng116 = new Place("116",new LatLng(23.868825,       90.4530383));
////        Place latLng117 = new Place("117",new LatLng(23.8688183,      90.4530333));
////        Place latLng118 = new Place("118",new LatLng(23.8688,         90.45305));
////        Place latLng119 = new Place("119",new LatLng(23.8687983,      90.4530583));
////        Place latLng120 = new Place("120",new LatLng(23.8688167,      90.4530917));
////        Place latLng121 = new Place("121",new LatLng(23.86882,        90.4530933));
////        Place latLng122 = new Place("122",new LatLng(23.8688233,      90.4530817));
////        Place latLng123 = new Place("123",new LatLng(23.8688283,      90.45305));
////        Place latLng124 = new Place("124",new LatLng(23.8688367,      90.45303));
////        Place latLng125 = new Place("125",new LatLng(23.8688333,      90.4530433));
////        Place latLng126 = new Place("127",new LatLng(23.8688333,      90.4530467));
////        Place latLng127 = new Place("129",new LatLng(23.86883,        90.453045));
////        Place latLng128 = new Place("128",new LatLng(23.8688217,      90.4530917));
////        Place latLng129 = new Place("129",new LatLng(23.86882,        90.453095));
////        Place latLng130 = new Place("130",new LatLng(23.8688233,      90.4530817));
////        Place latLng131 = new Place("131",new LatLng(23.86881,        90.453045));
////        Place latLng132 = new Place("132",new LatLng(23.86881,        90.4530383));
////        Place latLng133 = new Place("133",new LatLng(23.8687933,      90.45301));
//        Place latLng134 = new Place("B",new LatLng(23.79062,90.416165));
//        Place latLng135 = new Place("C",new LatLng(23.789436,90.416363));
//        Place latLng136 = new Place("D",new LatLng(23.789180,90.416426));
//        Place latLng137 = new Place("E",new LatLng(23.788010,90.416742));
////        Place latLng138 = new Place("F",new LatLng(23.789436,90.416363));
////        Place latLng139 = new Place("G",new LatLng(23.789180,90.416426));
////        Place latLng140 = new Place("H",new LatLng(23.788908,90.416354));
////        Place latLng141 = new Place("I",new LatLng(23.788660,90.415876));
////        Place latLng142 = new Place("J",new LatLng(23.788583,90.416846));
////        Place latLng143 = new Place("K",new LatLng(23.788171,90.416453));
////        Place latLng144 = new Place("L",new LatLng(23.788010,90.416742));
////        Place latLng145 = new Place("M",new LatLng(23.8374452,	90.3691546));
////        Place latLng146 = new Place("N",new LatLng(23.7582017,	90.4176633));
////        Place latLng147 = new Place("O",new LatLng(23.7498,	90.41313));
////        Place latLng148 = new Place("P",new LatLng(23.75828,	90.4174733));
//
//        latLngArrayList.add(latLng1);
////        latLngArrayList.add(latLng2);
////        latLngArrayList.add(latLng3);
////        latLngArrayList.add(latLng4);
////        latLngArrayList.add(latLng5);
////        latLngArrayList.add(latLng6);
////        latLngArrayList.add(latLng7);
////        latLngArrayList.add(latLng8);
////        latLngArrayList.add(latLng9);
////        latLngArrayList.add(latLng10);
////        latLngArrayList.add(latLng12);
////        latLngArrayList.add(latLng13);
////        latLngArrayList.add(latLng14);
////        latLngArrayList.add(latLng15);
////        latLngArrayList.add(latLng16);
////        latLngArrayList.add(latLng17);
////        latLngArrayList.add(latLng18);
////        latLngArrayList.add(latLng19);
////        latLngArrayList.add(latLng20);
////        latLngArrayList.add(latLng21);
////        latLngArrayList.add(latLng22);
////        latLngArrayList.add(latLng23);
////        latLngArrayList.add(latLng24);
////        latLngArrayList.add(latLng25);
////        latLngArrayList.add(latLng26);
////        latLngArrayList.add(latLng27);
////        latLngArrayList.add(latLng28);
////        latLngArrayList.add(latLng29);
////        latLngArrayList.add(latLng30);
////        latLngArrayList.add(latLng31);
////        latLngArrayList.add(latLng32);
////        latLngArrayList.add(latLng33);
////        latLngArrayList.add(latLng34);
////        latLngArrayList.add(latLng35);
////        latLngArrayList.add(latLng36);
////        latLngArrayList.add(latLng37);
////        latLngArrayList.add(latLng38);
////        latLngArrayList.add(latLng39);
////        latLngArrayList.add(latLng40);
////        latLngArrayList.add(latLng41);
////        latLngArrayList.add(latLng42);
////        latLngArrayList.add(latLng43);
////        latLngArrayList.add(latLng44);
////        latLngArrayList.add(latLng45);
////        latLngArrayList.add(latLng46);
////        latLngArrayList.add(latLng47);
////        latLngArrayList.add(latLng48);
////        latLngArrayList.add(latLng49);
////        latLngArrayList.add(latLng50);
////        latLngArrayList.add(latLng51);
////        latLngArrayList.add(latLng52);
////        latLngArrayList.add(latLng53);
////        latLngArrayList.add(latLng54);
////        latLngArrayList.add(latLng55);
////        latLngArrayList.add(latLng56);
////        latLngArrayList.add(latLng57);
////        latLngArrayList.add(latLng58);
////        latLngArrayList.add(latLng59);
////        latLngArrayList.add(latLng60);
////        latLngArrayList.add(latLng61);
////        latLngArrayList.add(latLng62);
////        latLngArrayList.add(latLng63);
////        latLngArrayList.add(latLng64);
////        latLngArrayList.add(latLng65);
////        latLngArrayList.add(latLng66);
////        latLngArrayList.add(latLng67);
////        latLngArrayList.add(latLng68);
////        latLngArrayList.add(latLng69);
////        latLngArrayList.add(latLng70);
////        latLngArrayList.add(latLng71);
////        latLngArrayList.add(latLng72);
////        latLngArrayList.add(latLng73);
////        latLngArrayList.add(latLng74);
////        latLngArrayList.add(latLng75);
////        latLngArrayList.add(latLng76);
////        latLngArrayList.add(latLng77);
////        latLngArrayList.add(latLng78);
////        latLngArrayList.add(latLng79);
////        latLngArrayList.add(latLng80);
////        latLngArrayList.add(latLng81);
////        latLngArrayList.add(latLng82);
////        latLngArrayList.add(latLng83);
////        latLngArrayList.add(latLng84);
////        latLngArrayList.add(latLng85);
////        latLngArrayList.add(latLng86);
////        latLngArrayList.add(latLng87);
////        latLngArrayList.add(latLng88);
////        latLngArrayList.add(latLng89);
////        latLngArrayList.add(latLng90);
////        latLngArrayList.add(latLng91);
////        latLngArrayList.add(latLng92);
////        latLngArrayList.add(latLng93);
////        latLngArrayList.add(latLng94);
////        latLngArrayList.add(latLng95);
////        latLngArrayList.add(latLng96);
////        latLngArrayList.add(latLng97);
////        latLngArrayList.add(latLng98);
////        latLngArrayList.add(latLng99);
////        latLngArrayList.add(latLng100);
////        latLngArrayList.add(latLng101);
////        latLngArrayList.add(latLng102);
////        latLngArrayList.add(latLng103);
////        latLngArrayList.add(latLng104);
////        latLngArrayList.add(latLng105);
////        latLngArrayList.add(latLng106);
////        latLngArrayList.add(latLng107);
////        latLngArrayList.add(latLng108);
////        latLngArrayList.add(latLng109);
////        latLngArrayList.add(latLng110);
////        latLngArrayList.add(latLng111);
////        latLngArrayList.add(latLng112);
////        latLngArrayList.add(latLng113);
////        latLngArrayList.add(latLng114);
////        latLngArrayList.add(latLng115);
////        latLngArrayList.add(latLng116);
////        latLngArrayList.add(latLng117);
////        latLngArrayList.add(latLng118);
////        latLngArrayList.add(latLng119);
////        latLngArrayList.add(latLng120);
////        latLngArrayList.add(latLng121);
////        latLngArrayList.add(latLng122);
////        latLngArrayList.add(latLng123);
////        latLngArrayList.add(latLng124);
////        latLngArrayList.add(latLng125);
////        latLngArrayList.add(latLng126);
////        latLngArrayList.add(latLng127);
////        latLngArrayList.add(latLng128);
////        latLngArrayList.add(latLng129);
////        latLngArrayList.add(latLng130);
////        latLngArrayList.add(latLng131);
////        latLngArrayList.add(latLng132);
////        latLngArrayList.add(latLng133);
//        latLngArrayList.add(latLng134);
//        latLngArrayList.add(latLng135);
//        latLngArrayList.add(latLng136);
//        latLngArrayList.add(latLng137);
////        latLngArrayList.add(latLng138);
////        latLngArrayList.add(latLng139);
////        latLngArrayList.add(latLng140);
////        latLngArrayList.add(latLng141);
////        latLngArrayList.add(latLng142);
////        latLngArrayList.add(latLng143);
////        latLngArrayList.add(latLng144);
////        latLngArrayList.add(latLng145);
////        latLngArrayList.add(latLng146);
////        latLngArrayList.add(latLng147);
////        latLngArrayList.add(latLng148);
        dummyLatLngArrayList.clear();
        dummyLatLngArrayList.addAll(latLngArrayList);
        latLngArrayList.clear();

        for (int i=0;i<dummyLatLngArrayList.size();i++) {
            if (i== 0) {
                PREVIOUS_LATIUDE = dummyLatLngArrayList.get(i).getLatlng().latitude;
                PREVIOUS_LONGITUDE = dummyLatLngArrayList.get(i).getLatlng().longitude;
                latLngArrayList.add(dummyLatLngArrayList.get(i));
            } else {
                Location temploc = new Location("temploc-");
                temploc.setLatitude(PREVIOUS_LATIUDE);
                temploc.setLongitude(PREVIOUS_LONGITUDE);
                Location currentLocation = new Location("current");
                currentLocation.setLatitude(dummyLatLngArrayList.get(i).getLatlng().latitude);
                currentLocation.setLongitude(dummyLatLngArrayList.get(i).getLatlng().longitude);
                float tempDistance = currentLocation.distanceTo(temploc);
                Log.e(""+i,""+tempDistance/1000);
                if ( tempDistance>50) {
                    // Log.e("count",""+i);
                    latLngArrayList.add(dummyLatLngArrayList.get(i));
                    Distance = Distance + tempDistance;
                    PREVIOUS_LATIUDE = dummyLatLngArrayList.get(i).getLatlng().latitude;
                    PREVIOUS_LONGITUDE = dummyLatLngArrayList.get(i).getLatlng().longitude;
                }
            }

        }

        for (Place p: latLngArrayList){
            Log.i("Places before sorting", "Place: " + p.name);
        }

        latLng = new LatLng(latLngArrayList.get(0).getLatlng().latitude,latLngArrayList.get(0).getLatlng().longitude);
   //     sort the list, give the Comparator the current location
        Collections.sort(latLngArrayList, new SortPlaces(latLng));

        for (Place p: latLngArrayList){
            Log.i("Places after sorting", "Place: " + p.name);
        }
        dummyLatLngArrayList.clear();
        dummyLatLngArrayList.addAll(latLngArrayList);
        Toast.makeText(this, ""+dummyLatLngArrayList.size(), Toast.LENGTH_SHORT).show();
        latLngArrayList.clear();
        int counnt = 1;
        if (dummyLatLngArrayList.size()<=23) {
            latLngArrayList = dummyLatLngArrayList;
        } else {
            int divi = (int) Math.round(dummyLatLngArrayList.size()/21);
            for (int i=0; i<dummyLatLngArrayList.size();i++) {
                if (i==0||i== dummyLatLngArrayList.size()-1) {
                    latLngArrayList.add(dummyLatLngArrayList.get(i));
                } else {
                    counnt = counnt + divi;
                    if (counnt<dummyLatLngArrayList.size()) {
                        latLngArrayList.add(dummyLatLngArrayList.get(counnt));
                    }

                }
            }
        }


        Toast.makeText(this, ""+latLngArrayList.size(), Toast.LENGTH_SHORT).show();
        Log.e("distance",""+Distance/1000);


        StringBuffer encodeString = new StringBuffer();
        for (int i = 1;i<latLngArrayList.size()-1;i++) {
            if (i==1) {
                Double d1 = latLngArrayList.get(i).getLatlng().latitude*100000;
                Double d2 = latLngArrayList.get(i).getLatlng().longitude*100000;
                Log.e(""+i,""+d1.intValue()+" "+d2.intValue());
                String encode = encodeSignedNumber(d1.intValue())+""+encodeSignedNumber(d2.intValue());
                encodeString.append(encode);
            } else {

                    Double d3 = (latLngArrayList.get(i).getLatlng().latitude * 100000);
                    Double d4 = (latLngArrayList.get(i).getLatlng().longitude * 100000);
                    Double d5 = (latLngArrayList.get(i - 1).getLatlng().latitude * 100000);
                    Double d6 = (latLngArrayList.get(i - 1).getLatlng().longitude * 100000);
                    int a = d3.intValue() - d5.intValue();
                    int b = d4.intValue() - d6.intValue();
                    //Log.e("" + i, "" + a + " " + b);
                    Log.e(""+i,""+latLngArrayList.get(i).getLatlng().latitude+" "+latLngArrayList.get(i).getLatlng().longitude);
                    String encode = encodeSignedNumber(a) + "" + encodeSignedNumber(b);
                    encodeString.append(encode);

            }
        }

//        String encode = encodeSignedNumber(3850000)+""+encodeSignedNumber(-12020000);
//        encodeString.append(encode);
//        encode = encodeSignedNumber(220000)+""+encodeSignedNumber(-75000);
//        encodeString.append(encode);
//        encode = encodeSignedNumber(255200)+""+encodeSignedNumber(-550300);
//        encodeString.append(encode);
        StringBuffer way = new StringBuffer();
        for (int i=1;i<latLngArrayList.size()-1;i++) {
            if (i == latLngArrayList.size() - 2) {
                way.append(latLngArrayList.get(i).getLatlng().latitude + "%20" + latLngArrayList.get(i).getLatlng().longitude);
            } else {
                way.append(latLngArrayList.get(i).getLatlng().latitude + "%20" + latLngArrayList.get(i).getLatlng().longitude + "%7C");
            }

        }
        Toast.makeText(this, ""+encodeString.toString(), Toast.LENGTH_SHORT).show();
        Log.e("encode string", way.toString());
        String origin = String.valueOf(latLngArrayList.get(0).getLatlng().latitude)+","+String.valueOf(latLngArrayList.get(0).getLatlng().longitude);
        String destination = String.valueOf(latLngArrayList.get(latLngArrayList.size()-1).getLatlng().latitude)+","+String.valueOf(latLngArrayList.get(latLngArrayList.size()-1).getLatlng().longitude);
        String finalURL="https://directionsdebug.firebaseapp.com/?origin="+origin+"&destination="+destination+"&mode=driving&waypoints="+way+"&key=AIzaSyB6rrxv37TyKxvGQYTn1WtlrMHnsEZyakQ";
        Log.e("Final URL",""+finalURL);
    }

    private String encodeSignedNumber(int num) {
        int sgn_num = num << 1;
        if (num < 0) {
            sgn_num = ~(sgn_num);
        }
        return(encodeNumber(sgn_num));
    }

    private String encodeNumber(int num) {

        StringBuffer encodeString = new StringBuffer();

        while (num >= 0x20) {
            encodeString.append((char)((0x20 | (num & 0x1f)) + 63));
            num >>= 5;
        }

        encodeString.append((char)(num + 63));

        return encodeString.toString();

    }
}
