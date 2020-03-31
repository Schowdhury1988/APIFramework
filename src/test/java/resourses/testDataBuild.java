package resourses;

public class testDataBuild {

    public String addPlacePayload(String name, String phone_number, String address){
        String p ="{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"phone_number\": \""+phone_number+"\",\n" +
                "  \"address\": \""+address+"\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
        return p;
    }

    public String deletePlacePayload(String place_id){
        String delete= "{\n" +
                "    \"place_id\": \""+place_id+"\"\n" +
                "}";
        return delete;
    }
}
