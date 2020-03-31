package stepDefinations;

import io.cucumber.java.Before;

import java.io.IOException;

public class hooks {


    @Before("@deletePlace")
    public void beforeScenario() throws IOException {


        stepDefinatons s = new stepDefinatons();
        if(stepDefinatons.place_id==null) {
            s.add_Place_Payload_with("shyd", "444444444", "105-90");
            s.user_calls_API_S_by_http_request("addPlaceAPI", "POST");
            s.verify_place_id_created_maps_to_using("shyd", "getPlaceAPI");
        }

    }
}
