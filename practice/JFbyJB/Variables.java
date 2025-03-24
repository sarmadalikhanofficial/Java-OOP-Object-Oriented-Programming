class Answer {

    static boolean showExpectedResult = true;
    static boolean showHints = false;

    static String fillInTheBlank(String season, int numberOfCups, String adjective) {
        String story = "On a " + adjective + " " + season + " day, I drink a minimum of " + numberOfCups + " cups of coffee.";
        return story;
    }

}

class Variables{
    public static void main(String[] args){
        String season = "winter";
        int numberOfCups = 4;
        String adjective = "cold";
        String result = Answer.fillInTheBlank(season, numberOfCups, adjective);
        System.out.println(result);
    }
}


// Parameters
// season : A string representing a season
// numberOfCups : An integer representing the number of cups of coffee
// adjective : A string representing an adjective
