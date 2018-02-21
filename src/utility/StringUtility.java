package utility;

public class StringUtility {

    public static String CreateParenthesizedList(Object... args) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        for(int i = 0; i < args.length; i++) {
            boolean isString = (args[i] instanceof String);
            if(isString) { builder.append("'"); }
            builder.append(args[i]);
            if(isString) { builder.append("'"); }

            if(i != args.length - 1) {
                builder.append(", ");
            }
        }

        builder.append(")");

        return  builder.toString();
    }

    public static String CreateQueryParenthesizedList(int numColumns) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        for(int i = 0; i < numColumns; i++) {

            builder.append('?');

            if(i != numColumns - 1) {
                builder.append(", ");
            }
        }

        builder.append(")");

        return  builder.toString();
    }

}

