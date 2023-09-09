package com.example.shayari2023;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {

    ImageView backbtn, usericon;
    GridView gridview;
    public static int[] CatImgArr = new int[]{
            R.drawable.life,
            R.drawable.morningshayari,
            R.drawable.alone,
            R.drawable.friendshipshayari,
            R.drawable.funnyshayari,
            R.drawable.loveshayari,
            R.drawable.goodnightshayari,
            R.drawable.sadshayari,
            R.drawable.anger,
            R.drawable.romanticshayari,
            R.drawable.breakupshayari
    };

    public static int[] CatColArr = new int[]{
            R.drawable.ocean_breeze,
            R.drawable.sunset_serenade,
            R.drawable.lavender_dream,
            R.drawable.spring_meadow,
            R.drawable.candy_crush,
            R.drawable.electric_shock,
            R.drawable.tropical_paradise,
            R.drawable.cosmic_galaxy,
            R.drawable.vintage_charm,
            R.drawable.enchanted_forest,
            R.drawable.galactic_glow,
            R.drawable.golden_hour,
            R.drawable.midnight_magic,
            R.drawable.pastel_delight
    };

    public static String[] catarray = new String[]{"Trending Shayari",
            "Morning Shayari",
            "Alone Shayari",
            "FriendShip shayari",
            "Funny Shayari",
            "Love Shayari",
            "Night Shayari",
            "Sad Shayari",
            "Anger Shayari",
            "Romantic Shayari",
            "Break up Shayari"};

    public static String[][] shayaries = new String[][]{
            //
            {"Tere saath guzre lamhon ki yaadon ko,\n" +
                    "Main khud mein hi chhupake rakh leta hoon",
                    "Koi paas hai door hai, juda kaisi dil se?\n" +
                            "Kya farq hai phir bhi, zindagi mein unki kami toh hai.",

                    "Dard ki had se guzarna hai, mujhe,\n" +
                            "Kisi ke dil mein basna hai, mujhe.",

                    "Tere bina jeene ki khwaish mein,\n" +
                            "Khud ko bhula baitha hoon",

                    "Ishq ki gehrai mein dooba hua hoon,\n" +
                            "Yaadon ki bahti darya mein khoya hua hoon",

                    "Teri aankhon ke dariya ka utarna bhi zaroori tha,\n" +
                            "Mohabbat bhi zaroori thi, bichhadna bhi zaroori tha",

                    "Kuch toh majbooriyaan rahi hongi yun tere jaane se,\n" +
                            "Milna toh tha magar judaai ka gham bhi tha.",

                    "Dil ki baat zubaan pe aane se pehle,\n" +
                            "Mohabbat hai gunah isko samajhne se pehle",

                    "Zindagi ki raah mein aaye mod pe,\n" +
                            "Humsafar bankar saath chhod na dena.",

                    "Woh jinhe hum chahte hain, jaan se bhi zyada,Unhi se humari khata ho jati hai."},


            //
            {"Chandni raat ki neend se jagte hi, Suraj ki pehli kiran se muskurana hai.",

                    "Subah ka har pal zindagi de aapko, Din ka har lamha khushiyan de aapko.",

                    "Utho, jago, aur nayi raah dekho, Zindagi ki subah aapke saath hai.",

                    "Chand se pyaara hai roshan chehra aapka, Aapki muskurahat se har subah hai roshan.",

                    "Raat ki gehrai se nikal kar, Subah ki udaan bharna hai.",

                    "Har subah aapki muskurahat se roshan ho, Zindagi ki har subah aapke naam ho.",

                    "Subah ki pehli kiran chhu jaye aapko, Dilkash nazar aaye aapko.",

                    "Suraj ki pehli kiran se jagmagata hai sansar, Aap bhi ujalon mein khilte raho har roz.",

                    "Subah ki roshni saath ho aapke, Khushi ki har ghadi aapke paas ho.",

                    "Subah ki kiran boli mujhse,\n" +
                            "Uthkar dekho kitna haseen nazara hai."},

            //
            {"Na Sath Hai Kisi Ka Na Sahara Hai Koi\n" +
                    "Na Ham Hain Kisi Ke Na Hmara Hai Koi",

                    "Chehre ki hasi se har gam chupao\n" +
                            "Bahut kuchh bolo par kuchh na batao\n" +
                            "Khud na rutho kabhi par sabko manao\n" +
                            "Ye raz hai zindagi ka, bas jeete jao",

                    "Door rehne wale terko ek bat kehna chahta hu,\n" +
                            "agar mera khyal aaye to apna khyal rakhna",

                    "Woh humsey apni marzi se baat krtey hai\n" +
                            "aur hum bhi kitney pagal hai ke unki marji ka intezar kartey hai",

                    "Tumhein maloom bhi hai main tanha jee nahin sakta\n" +
                            "Meri aadat badalne tak to mere saath ruk jao",

                    "Phir wohi raat wohi hum wohi tanhaai hai\n" +
                            "Phir har ik chott mohabbat ki ubhar aayi hai",

                    "Maine Sikhe Hain Mohabbat Se Mohabbat Ke Asool\n" +
                            "Sab Se Mushkil Hai Kisi Apne Ko Apna Karna",

                    "Mujh Ko Rula Kar Vo Bhi Roya To Hoga\n" +
                            "Muh Aansuo Se Usne Bhi Dhoya To Hoga\n" +
                            "Agar Na Kiya Hai Hasil Kuch Humne Pyar Mein\n" +
                            "Kuch Na Kuch Usne Bhi Khoya To Hoga.",

                    "Jaruri nahi jo khushi de usi se pyar ho mere dosto\n" +
                            "sacchi mohabbat to aksar dil todne wale se hoti hai",

                    "Muft Ka Ehsaan Na Lena Yaaro\n" +
                            "Dil Abhi Aur Bhi Saste Honge"},

            //
            {
                    "Dosti se qeemti koi jageer nahi, dosti se khubsoorat koi tasveer nahi, dosti to sirf ek kaccha dhaga hai, dhage se majboot koi janjeer nahi",

                    "Dosti ka rishta is duniya mein sabse jyada khaas hota hai kyuki yeh ek aisa rishta hai jo koi bhi swarth ke bina hi do logo ke beech mein madhur sambandh nirman karta hai",

                    "Dosti kabhi bhi amiri ya garibi dekh kar nahi hota dost banne ke liye bas ek dusre ke soch aur dil milna chahiye",

                    "Agar aapke paas koi best friend hai to aap bahut khushnaseeb ho kyuki aajkal ki duniya mai saccha yaar milna bahut hi mushkil ho chuka hai",

                    "Yeh post par maujood kuch friendship shayari aapke priy doston ke saath jarur sajha karen taaki aaps mein dosti yaari ka rishta aur bhi majboot bane",

                    "Dosti ek safaid chandni raat hai, jismein har dil ki baat hoti hai, dosti ek khushnuma ehsaas hai, jismein har dil ko pyaar milta hai",

                    "Dosti ek paimana hai jismein har dil ka pyaar bhara hota hai, dosti ek aaina hai jismein har dil ka haal dikhta hai",

                    "Dosti ek phool hai jiske khushboo se har dil mehekta hai, dosti ek taara hai jiske chamak se har raat roshan hoti hai",

                    "Dosti ek nagma hai jise har dil gaata hai, dosti ek khwaab hai jise har dil dekhta hai",

                    "Dosti ek rangin panno ki kitaab hai, jismein har dil ki kahani likhi hoti hai"},


            //
            {"Iss Duniya Mein Lakhon Log Rahte Hain, Koi Hansta Hai Toh Koi Rota Hai, Par Sabse Sukhi Wahi Hota Hai, Jo Shaam Ko Do Peg Maar Ke Sota Hai",

                    "Na Wafa Ka Jikr Hoga, Na Wafa Ki Baat Hogi, Ab Mohabbat Jisse Bhi Hogi, Raakhi Ke Baad Hogi",

                    "Arj Kiya Hai… Tere Chehre Par Udasi, Aankhon Mein Nami Hai, Tere Chehare Par Udasi, Aankhon Mein Nami Hai, Taata Namak Istemaal Karo, Kyuki Tum Me Aayodeen Ki Kami Hai",

                    "Jab Koyi Zindagi Mein Bahut Khaas Ban Jaye, Uske Baare Mein Sochna Hi Uska Ehsaas Ban Jaye, To Maang Lena Khuda Se Use Zindagi Bhar Ke Liye, Ise Se Pahle Ki Uski Maa Kisi Aur Ki Saas Ban Jaye",

                    "Zindagi Mein Sadaa Muskurate Raho, Faasle Kam Karo Dil Se Dil Milate Raho, Dard Kaisa Bhi Ho Koi Gham Na Karo, Iodex Kharido Aur Lagaate Raho",

                    "Arz kiya hai… Tere Chehre Par Udasi, Aankhon Mein Nami Hai, Tere Chehare Par Udasi, Aankhon Mein Nami Hai, Taata Namak Istemaal Karo, Kyuki Tum Me Aayodeen Ki Kami Hai",

                    "Jab Koyi Zindagi Mein Bahut Khaas Ban Jaye, Uske Baare Mein Sochna Hi Uska Ehsaas Ban Jaye, To Maang Lena Khuda Se Use Zindagi Bhar Ke Liye, Ise Se Pahle Ki Uski Maa Kisi Aur Ki Saas Ban Jaye",

                    "Zindagi Me Sadaa Muskurate Raho, Faasle Kam Karo Dil Se Dil Milate Raho, Dard Kaisa Bhi Ho Koi Gham Na Karo, Iodex Kharido Aur Lagaate Raho"},

            //
            {"Tera Saath hai Toh mujhe kya kami hai\n" +
                    "Teri har muskan se mili mujhe kushi hai\n" +
                    "Muskuraate Rehna isi Tarah humesha\n" +
                    "Kyonki teri is muskan mein meri jaan basi hai",

                    "kon kaheta hai taj mahel banane ke lie dolat nahi milti.\n" +
                            "taj mahel banane ke lie dolat to milti he magar mohbatt karne ke lie mumtaj nahi milti.",

                    "Mile to hazaron log the Zindagi me ,\n" +
                            "Par wo sabse alag tha jo kismat me nahi tha...",

                    "Soch milni chahiye\n" +
                            "dil toh apne aap hi mil jaate hai.!",

                    "Tu Shaq Na Kar Mere Jazbato Pe,\n" +
                            "Tere Sath Hi Zindagi Meri Khubsurat Hai,\n" +
                            "Jitni Ehmiyat Hai Pani Ki Marte Insan K Liye,\n" +
                            "Bus Utni Hi Muje Teri Zarurat Hai...",

                    "Tum ho shubah sham ki tarah.\n" +
                            "Tum ho khushiyo ke paigam ki tarah.\n" +
                            "Hamne kab bhulaya hai aapko.\n" +
                            "Tum yaad rahte ho mujhe mere naam ki tarah",

                    "Uski Chahat Se Ikrar Na Karte..\n" +
                            "Uski Kasmo Ka Aitbar Na Krte,\n" +
                            "Agar Pata Hota Hum Sirf Mazak H Unke Liye,\n" +
                            "Ksam Se Jaan De Dete Par Pyar Nahi Krte..!! Ishan",

                    "Udas na hona hum aap ke sath hai\n" +
                            "Nazar se door per dil ke pass hai\n" +
                            "Palkon ko band ker ke dil se yaad karna\n" +
                            "Hum hamesha ap ke liye ek ehsaas hai",

                    "Zeher vekh ke pita ta ki pita,\n" +
                            "ishq soch ke kita te ki kita,\n" +
                            "dil de ke je dil len di umeed rakhi,\n" +
                            "eho jeha pyar kita te ki kita! ! !",

                    "Pyaar Karna Tumne Sikhaya,\n" +
                            "Pyaar Pe Yakeen Karna Tumne Sikhaya,\n" +
                            "Sapne Sajana Tumne Sikhaya,\n" +
                            "Bas Tumhare Bina Jeena Nahi Sikhaya…"},

            //
            {"Raat Kafi Ho Chuki Hai Ab Chiragh Bujha Dijiye, Ek Haseen Khwab Rah Dekhta Hai Apki, Bs Plko K Prde Gira Dijiye",

                    "Daulat Ki Chaah Thi Toh Kamane Nikal Gaye, Daulat Mili To Hath Se Rishte Nikal Gaye, Bachchon Ke Sath Rehne Ki Fursat Na Mil Saki, Fursat Mili To Bachche Hi Ghar Nikal Gaye",

                    "Dosti Se Qeemti Koi Jageer Nahi, Dosti Se Khubsoorat Koi Tasveer Nahi, Dosti To sirf Ek Kaccha Dhaga Hai, Dhage Se Majboot Koi Janjeer Nahi",

                    "One day I wish my dream would come true And I’d wake up next to you. Till then Good Night!",

                    "Night is the wonderful opportunity to take rest, to forgive, to smile, to get ready for all the battles that you have to fight tomorrow.",

                    "It is better to sleep on things beforehand than lie awake about them afterwards.",

                    "Every night is a chance to recharge and a time to relax. Take a moment before you fall asleep to be thankful for this blessing and a god who interacts.",

                    "Never lose hope. You never know what tomorrow will bring.",

                    "The sea will grant each man new hope, and sleep will bring dreams of home. Good night.",

                    "Sleep tight. I’ll see you in the morning when the sky is bright.",

                    "Raat Ki Tanhai Mein Akele The Hum, Dard Ki Mehfilo Mein Ro Rahe The Hum, Aap Hamare Bhale Hi Kuch Nahi Lagte, Fir Bhi Aapke Bina Bilkul Adhure Hain Hum",

                    "Raat Ki Chandni Mein Khushiyon Ka Safar Ho, Pyar Ki Galiyon Mein Mil Jaye Humko Itna Pyar, Ki Humein Kabhi Na Ho Udaas, Bas Yahi Dua Karte Hain Hum Har Raat Ko Sone Se Pehle"},

            //
            {"Acha hai Jo tu Meri takleef nahin samajti, Agar samajti toh tuhje bhi takleef hoti, Aur woh mujhe acha nahin lagta",

                    "Tere Jaane Ke Baad Kaun Rokta Humein Jee Bhar Kar Khud Ko BarBaad Kiya Humne",

                    "Kafan ko utha kar deedar kar lo, Band ho gayi hai woh aankhein jinko tum rulaya karty thy",

                    "Yaadon ki kimat wo kya jaane, Jo khud hi yaadon ko mita baithe hain, Yaadon ki kimat to unse puchoo jo yaadon ke sahare, Jindagi bita diya karte hain",

                    "Jab Yaad Tumhari Aati Hai, Dil Khun Ke Aansu Rota Hai, Yeh Dard Denewala Kya Jane, Dil Ka Dard Kaisa Hota Hai",

                    "Dil ke zakhm aansuon se humne dho diye, Apni aankhon ko humne ro diye, Tumne kaha tha nafrat hai mujhse, Toh humne apni mohabbat ko kho diye",

                    "Tumne chaha hi nahi toh izhaar kya karte, Hum zikr apna hi nahi toh faryaad kya karte, Tumhein laakhon mubarak ho ye chand raat, Hum toh chand ko dekh kar bhi Eid ka intezar kya karte",

                    "Dil ke zakhm bharne mein waqt toh lagta hai, Par un zakhmon ko bhulane mein umar lag jati hai",

                    "Dard ki mehfil mein ek shama roshan hai, Woh shama jisne humein tanha chod diya hai",

                    "Kabhi kabhi dil chahta hai ki tumhein dard de doon, Par phir sochta hoon ki tumhein dard ka ehsaas hi nahi hai"},

            //
            {"Your anger will get you punished. Your anger will punish you on its own. The person with a fast temper who is angered will make a fool of themselves in time. We must learn to regulate our anger and be the larger person.",

                    "Anger does more harm to oneself than to others.",

                    "One of my qualities is that I don't get angry, I just get upset.",

                    "Anger blinds the eyes and makes the tongue's horses uncontrollable.",

                    "Anger is a condition in which the tongue works faster than the mind.",

                    "Anger is the wind that extinguishes the lamp of intelligence.",

                    "Never be angry with your mother, friends. It is the prayer of the mother that saves you from every trouble.",

                    "If you are always angry and complaining, people will not have time for you.",

                    "A foolish person loses their temper, but a wise person keeps it under control.",

                    "A word spoken in anger can be so poisonous that it can destroy your thousands of loving words in a minute.",
                    "Anger is a fire that burns everything in its path, leaving behind only ashes and regret.",
                    "Anger is like a storm that rages within us, destroying everything in its path."},

            //
            {"Ek ada aapki muskurane ki, Ek ada aapki dil me bas jane ki…! Ek chehra aapka chaand saa.. Ek jid hamari chaand ka paane ki",

                    "Hum Tumse Milne Aaye The Yaad Hain Kya aaj Bhi Wo Pal Jab Pehli Nazar Me Hume Dekh Tum Dhire se Muskuraye The",

                    "Kuch Baat Hain To Mujhse Keh Do Na Meri Duniya Me Aakar Reh Lo Na Ye Dil Taras Gaya hain Sunane Ko Phir Ek baar Pyar Se Pagal keh do Na",

                    "Unki Be-Rang Duniya Ko Phir Kisi Ne Khushiyo Se Bhar Diya Tha Phir Se Unhein Kisi Ne Rehne Ke Liye Ek Pyaara Sa Ghar Diya Tha Par Jaise Hi Unhone Us Ghar Ko Apna Samjha Makaan Malik Ne Phir Kirayedaar Badal Diya Tha",

                    "Aapko Meri Nazro Se Nazar Na Lage Koi Paraya Bhi Accha Is Kadar Na Lage Aapko Dekha Hain Hamesha Us Nazar Se Jis Nazar Se Aapko Hamari Nazar Na Lage",

                    "Zindagi Me Aapse Milena Bhi Jaruri Tha Ishq Kya Chiz Hain Ye Janana Bhi Jaruri Tha Meri Khushiyon Ka Khajana Ho Tum Isliye Apako Pana Meri Manjil Banana Bhi jaruri Tha",

                    "Aise Koi Subah Nahi Jab Tum Yaad Nahi Aati Har Roj Ye Dil Dua Karta Hain Ek Baar To Aapse Mulakaat Ho Pati",

                    "Bus Mohabbat Me Pehli Suruat Chal rahi hai Hamare Bich Ek dusre ko Dekhte Hai Baar Baar Par Kabhi Izhaar nahi kar Pate",

                    "Hum Hamesha Bindi, Payal Aur Jhumko Mein Uljhe Rehte Hai Aur Woh Daru, Cigarette Aur Nasha Mein Rehte Hai Hum Hamesha Saath Zindagi Jeene Ki Baat Karte Hai Aur Woh Humse Door Rehne Ki",

                    "Bahut Chaha Liya Dur Se Ab Izhaar Karna Baaki Hain Jo Simay Hain Ishq Ki Ab Unhe Paar Karna Baaki Hain Humse Tum Nazre Kab Tak Chupaoge Abhi To Aakho Ka Didaar Karna Baaki Hain"},

            //
            {"Aksar mohabbat mein aisa hota hai, ek baat karne ke liye tadapta hai, aur dusra us baat ko sunne ke liye tarasta hai",

                    "Rone ki saza na rulane ki saza hai, mohabbat mein jo dard mila hai uska sila hai",

                    "Ek khoobsurat sa rishta tha jo humne banaya tha, par tumne us rishte ko apne haathon se mitaya tha",

                    "Mujhe maaloom hai tum bahut khush ho is judaai se, par socha hai kabhi ki hum bhi toh tere saath khush the",

                    "Vo log jo tumko kabhi kabhi yaad aate hai, unmein se ek hum bhi hain jo tere bina tadap jaate hain",

                    "Kaisa sangdil hai sanam mera, jo mujhse door ho gaya hai, ab toh bas yaadon ka sahara hai jo mujhe sambhalta hai",

                    "Agar bichhadne se muskuraahat laut aaye tumhari, toh humein bhi khushi hogi ki humne tumhein khush dekha hai",

                    "Jo nazar se guzar jaate hai, unhein dil se bhulaaya nahi jaata",

                    "Dil ke zakhm bharne mein waqt toh lagta hai, Par un zakhmon ko bhulane mein umar lag jati hai",

                    "Kabhi kabhi dil chahta hai ki tumhein dard de doon, Par phir sochta hoon ki tumhein dard ka ehsaas hi nahi hai"}
    };

    public static void showToasting(Context contex, String message) {
        Toast.makeText(contex, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        showalert();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        backbtn = findViewById(R.id.backbtn);
        gridview = findViewById(R.id.categoryList);
        usericon = findViewById(R.id.usericon);


        backbtn.setOnClickListener(v -> {
            showalert();
        });

        CustomCatAdapter adapter = new CustomCatAdapter(this, R.layout.catitems, catarray);
        gridview.setAdapter(adapter);

        Intent i2 = new Intent(Categories.this, CatItems.class);
        Intent home = new Intent(Categories.this, Homepage.class);

        gridview.setOnItemClickListener((parent, view, position, id) -> {
            i2.putExtra("pos", position);
            showToasting(Categories.this, catarray[position]);
            startActivity(i2);
        });

        usericon.setOnClickListener(v -> {
            startActivity(home);
            finish();
        });


    }

    private void showalert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Categories.this);
        alertDialog.setTitle(Html.fromHtml("<font color='#651FFF'>Exit</font>"));
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = alertDialog.create();
        alert.setOnShowListener(arg0 -> {
            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.ElectricPurple));
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.black));
        });
        alert.show();
    }
}