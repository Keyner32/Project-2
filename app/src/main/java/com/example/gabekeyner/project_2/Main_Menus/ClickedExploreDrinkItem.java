package com.example.gabekeyner.project_2.Main_Menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;
import com.squareup.picasso.Picasso;

public class ClickedExploreDrinkItem extends AppCompatActivity {

    TextView titleView;
    TextView abvView;
    TextView descView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_explore_drink_item);


        final DrinksClassHelper helper = DrinksClassHelper.getInstance(ClickedExploreDrinkItem.this);

        titleView = (TextView) findViewById(R.id.titleView);

        abvView = (TextView) findViewById(R.id.abvView);

        descView = (TextView) findViewById(R.id.descView);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        int id = getIntent().getIntExtra("id", -1);

        String title = helper.getTitleByID(id);
        String abv = helper.getAbvByID(id);
        String desc = helper.getDescByID(id);

        switch (title) {

            case "Corona":
                Picasso.with(this)
                        .load("https://www.lionco.com/content/styles/landing_hero/public/corona_250x320.png")
                        .into(imageView);
                break;
            case "Coors":
                Picasso.with(this)
                        .load("https://www.inlandpackaging.com/wp-content/uploads/2015/09/coors_light-2015.png")
                        .into(imageView);
                break;
            case "Budlight":
            Picasso.with(this)
                    .load("http://qa.anheuser-busch.com/uploads/BudLight.png")
                    .into(imageView);
            break;
            case"805":
            Picasso.with(this)
                    .load("http://beereports.com/wp-content/uploads/2013/05/805-Bottle.jpg")
                    .into(imageView);
                //.fit()
            break;
            case"Guinness":
            Picasso.with(this)
                    .load("http://static1.squarespace.com/static/55a582f4e4b02ddf26a8250e/t/55bfb50ee4b0dc93097e80aa/1438627091986/Guinness.png?format=original")
                    .into(imageView);
            break;
            case"Sapporo":
            Picasso.with(this)
                    .load("http://va.worldclassbeer.com/wp-content/beer_spy/images/prodimages/Sapporo/lPremiumBottle.png")
                    .into(imageView);
            break;
            case"Budweiser":
            Picasso.with(this)
                    .load("http://www.cerveseriagrupomodelo.com/images/marcas/budweiser/budweiser_botella.png")
                    .into(imageView);
            break;
            case "Modelo":
            Picasso.with(this)
                    .load("http://www.origlio.com/sites/default/files/beverage/Grupo-Modelo_Modelo-Especial.png")
                    .into(imageView);
            break;
            case"Pacifico":
            Picasso.with(this)
                    .load("http://www.treuhouse.com/wp-content/uploads/2013/06/Pacifico.png")
                    .into(imageView);
            break;
            case"Stella Artois":
            Picasso.with(this)
                    .load("http://www.origindutch.com/wp-content/uploads/2015/08/stella-artois-330ml-bottle1.png")
                    .into(imageView);
            break;
            case"7 & 7":
                Picasso.with(this)
                        .load("http://noshable.lovewithfood.com/wp-content/uploads/2016/03/irish-drink-7.png")
                        .into(imageView);
                break;
            case"Blue Hawaiian":
                Picasso.with(this)
                        .load("http://az659704.vo.msecnd.net/v1/image/c_lpad,w_1500,h_1500/v1400603721/cocktail_blue_hawaiian-1.png")
                        .into(imageView);
                break;
            case"Long Island":
                Picasso.with(this)
                        .load("http://havana-club.ca/sites/default/files/long_island.png")
                        .into(imageView);
                break;
            case"Pina Colada":
                Picasso.with(this)
                        .load("http://s3.amazonaws.com/liquor/wp-content/uploads/2015/03/Draaanks-Pina-Colada.jpeg")
                        .into(imageView);
                break;
            case"Mojito":
                Picasso.with(this)
                        .load("http://marijuana.tm/wp-content/uploads/2016/01/mojito.png")
                        .into(imageView);
                break;
            case"White Russian":
                Picasso.with(this)
                        .load("http://www.kahlua.com/globalassets/classic-cocktails/white-russian/kahlua-white-russian-highlighted.png")
                        .into(imageView);
                break;
        }


        //Set text to seleccted itme on list
        titleView.setText(title);
        abvView.setText(abv);
        descView.setText(desc);

    }


}
