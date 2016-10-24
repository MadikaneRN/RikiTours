package za.co.whcb.tp2.rikitours.factories.tourGuide;

import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;

/**
 * Created by Encore on 10/24/2016.
 */
public class TourGuideFactory {
    public static Guide getGuide(Long id, String name, String surname,String cell,String email)
    {
        return new Guide.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .cell(cell)
                .email(email)
                .build();
    }
}
