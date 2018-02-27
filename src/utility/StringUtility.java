package utility;

public class StringUtility {

    public static String CreateParenthesizedList(Object... args) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);

            if (i != args.length - 1) {
                builder.append(", ");
            }
        }

        builder.append(")");

        return builder.toString();
    }

    public static String createSqlStatementColumnList(Object... args) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);
            builder.append(" = ?");

            if (i != args.length - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    public static String createQuestionMarkParenthesizedList(int numColumns) {
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

