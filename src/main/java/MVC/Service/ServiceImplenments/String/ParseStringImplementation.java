package MVC.Service.ServiceImplenments.String;

import MVC.Service.InterfaceService.String.ParseString;

public class ParseStringImplementation implements ParseString {

    @Override
    public Integer getIDMessage(String input) {
        String regex = "\\b\\d+\\b";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return 1;
        }
    }

    @Override
    public Integer getHistorySize(String input) {
        Integer historySize = 0;
        if (input.startsWith("History Size:")) {
            historySize = Integer.parseInt(input.split(":")[1].trim());
        }
        return historySize;
    }

    @Override
    public String extractUsername(String input) {
        String[] parts = input.split(" : ");
        if (parts.length > 0) {
            return parts[0];
        }
        return "";
    }
}
