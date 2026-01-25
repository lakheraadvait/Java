public class l_EnhancedSwitches {
    public static void main(String[] args) {
        String day = "eoe";
        switch(day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> System.out.println("It is a weekday 🤮.");
            case "Saturday", "Sunday" -> System.out.println("It's the weekend ✨!");
            default -> System.out.println("No day specified.");
        }
    }
}
