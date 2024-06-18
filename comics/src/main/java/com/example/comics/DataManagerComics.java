package com.example.comics;

import com.example.common.Card;
import com.example.common.DataManagerBase;
import com.example.common.Card;

import java.util.ArrayList;

public class DataManagerComics extends DataManagerBase {
    @Override
    public ArrayList<Card> getCards() {
        ArrayList<Card> allCards = new ArrayList<>();

        allCards.add(new Card()
                .setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Chris_Hemsworth_as_Thor.jpg/220px-Chris_Hemsworth_as_Thor.jpg")
                .setName("Thor")
        );


        allCards.add(new Card()
                .setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Chris_Hemsworth_as_Thor.jpg/220px-Chris_Hemsworth_as_Thor.jpg")
                .setName("Thor")
        );


        allCards.add(new Card()
                .setImageUrl("https://cdn.britannica.com/54/93454-050-5AC49E5E/Spider-Man-Tobey-Maguire-2.jpg")
                .setName("SpiderMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://cdn.britannica.com/54/93454-050-5AC49E5E/Spider-Man-Tobey-Maguire-2.jpg")
                .setName("SpiderMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://static.wikia.nocookie.net/p__/images/f/fe/Avengers_Endgame_poster_041_Variant_Textless.jpg/revision/latest/scale-to-width/360?cb=20190919010656&path-prefix=protagonist")
                .setName("IronMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://static.wikia.nocookie.net/p__/images/f/fe/Avengers_Endgame_poster_041_Variant_Textless.jpg/revision/latest/scale-to-width/360?cb=20190919010656&path-prefix=protagonist")
                .setName("IronMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://www.thefactsite.com/wp-content/uploads/2021/05/the-hulk-facts.jpg")
                .setName("Hulk")
        );

        allCards.add(new Card()
                .setImageUrl("https://www.thefactsite.com/wp-content/uploads/2021/05/the-hulk-facts.jpg")
                .setName("Hulk")
        );

        allCards.add(new Card()
                .setImageUrl("https://cdn11.bigcommerce.com/s-b70w3e4554/images/stencil/1280x1280/products/231/3808/001_PCS_Wolverine_10thscale__57080.1694627745.jpg?c=1")
                .setName("Wolverine")
        );

        allCards.add(new Card()
                .setImageUrl("https://cdn11.bigcommerce.com/s-b70w3e4554/images/stencil/1280x1280/products/231/3808/001_PCS_Wolverine_10thscale__57080.1694627745.jpg?c=1")
                .setName("Wolverine")
        );

        allCards.add(new Card()
                .setImageUrl("https://static.wikia.nocookie.net/marvel_dc/images/a/a5/Superman_Vol_5_1_Textless.jpg/revision/latest/scale-to-width-down/1200?cb=20180711061148")
                .setName("SuperMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://static.wikia.nocookie.net/marvel_dc/images/a/a5/Superman_Vol_5_1_Textless.jpg/revision/latest/scale-to-width-down/1200?cb=20180711061148")
                .setName("SuperMan")
        );
        allCards.add(new Card()
                .setImageUrl("https://static1.srcdn.com/wordpress/wp-content/uploads/2024/02/batman-with-his-arkham-asylum-gadgetx.jpg")
                .setName("Batman")
        );

        allCards.add(new Card()
                .setImageUrl("https://static1.srcdn.com/wordpress/wp-content/uploads/2024/02/batman-with-his-arkham-asylum-gadgetx.jpg")
                .setName("Batman")
        );

        allCards.add(new Card()
                .setImageUrl("https://images.bauerhosting.com/empire/2023/06/flash-3.jpg?ar=16%3A9&fit=crop&crop=top&auto=format&w=undefined&q=80")
                .setName("TheFlash")
        );

        allCards.add(new Card()
                .setImageUrl("https://images.bauerhosting.com/empire/2023/06/flash-3.jpg?ar=16%3A9&fit=crop&crop=top&auto=format&w=undefined&q=80")
                .setName("TheFlash")
        );

        allCards.add(new Card()
                .setImageUrl("https://i.guim.co.uk/img/media/fbb1974c1ebbb6bf4c4beae0bb3d9cb93901953c/10_7_2380_1428/master/2380.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=223c0e9582e77253911be07c8cad564f")
                .setName("Joker")
        );

        allCards.add(new Card()
                .setImageUrl("https://i.guim.co.uk/img/media/fbb1974c1ebbb6bf4c4beae0bb3d9cb93901953c/10_7_2380_1428/master/2380.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=223c0e9582e77253911be07c8cad564f")
                .setName("Joker")
        );

        allCards.add(new Card()
                .setImageUrl("https://images.immediate.co.uk/production/volatile/sites/3/2018/12/Aquaman-Movie-Poster-Aquaman-Classic-Costume-e0110b2.jpg?quality=90&resize=980,654")
                .setName("AquaMan")
        );

        allCards.add(new Card()
                .setImageUrl("https://images.immediate.co.uk/production/volatile/sites/3/2018/12/Aquaman-Movie-Poster-Aquaman-Classic-Costume-e0110b2.jpg?quality=90&resize=980,654")
                .setName("AquaMan")
        );


        return allCards;
    }

}
