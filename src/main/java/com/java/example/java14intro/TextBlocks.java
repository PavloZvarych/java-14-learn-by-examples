package com.java.example.java14intro;

/**
 * Text blocks were released in jdk 13, and improved in jdk 14 with new escape sequences
 * Official documentation: https://openjdk.java.net/jeps/368
 */
public class TextBlocks {

    public static void main(String[] args) {

        /*--------------------------------- JDK 13 ----------------------------------*/

        String stringsBeforeJava13 =
                "<div class=\"information trainer\">\n" +
                "\t<a href=\"tel:+4860694915\"><span class=\"fa fa-phone\" style=\"color: rgb(255, 0, 0)\"></span>&nbsp; +48 606-949-15</a>\n" +
                "</div>";

        /*
            The text blocks improve code readability.
            No escaping, newline, or tabs characters appear in the string.
            """ was chosen so that " character could appear unescaped inside text blocks.
        */
        String textBlocks =
                """
                <div class="information trainer">
                	<a href="tel:+4860694915"><span class="fa fa-phone" style="color: rgb(255, 0, 0)"></span>&nbsp; +48 606-949-15</a>
                </div>
                """;

        /*
            The code should be in a new line after opening fat delimiters (three double-quote characters).
            No newline character will be added after compilation.
            Check out the compiled class.
            The closing""" can appear after the last character.
            If you do not want to have \n character at the end, add a closing """ after your code.
         */
        String textBlockHtml = """
                <div class="second-row">""";

        /*
            \" - the use of escaping character permitted, but not necessary.
        */
        String textBlockWithEscapingCharacter = """
                <div class=\"information trainer\">
                """;

        /*
            \n - line terminator permitted, but not necessary.
         */
        String newLineTerminatorPermitted = """
                <div class="information trainer">\n
                """;

        /*
            Text block can be empty, but it is not recommended as it takes 2 lines of source code.
        */
        String emptyTextBlock = """
                """;

        /*
            Whitespace surrounding the content is generally(*) removed during compilation.
            Check out the compiled class.
            (*) - check out the next stringWithSpace string example.
         */
        String whitespaceSurroundingContentRemoved = """
                <nav class="navbar navbar-expand-lg navbar-light bg-light">              
                """;

        /*
            But if closing fat delimiters (""") have no leading space at all, space remains.
            That happens because of the peculiarity of the re-identation algorithm,
            that calculates how much leading space should be removed.
            It calculates the number of whitespace characters for every non-blank line
            and removes from every line the least number of whitespace.
         */
        String stringWithSpace = """
                  <div class="second-row">
                    <div class="information right-side"><a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook-square" style="color: rgb(255, 0, 0)"></i></a></div>
                    <div class="information right-side"><a href="https://www.youtube.com" target="_blank"><i class="fa fa-youtube-play" style="color: rgb(255, 0, 0)"></i></a></div>
                    <div class="information right-side"><a href="https://www.instagram.com" target="_blank"><i class="fa fa-instagram" style="color: rgb(255, 0, 0)"></i></a></div>
                  </div>
""";

        /*
            Text blocks are indistinguishable from string literals after compilation.
            Check out the compiled code.
         */
        String textBlocksIndistinguishableFromStringLiterals = """
                <span class="navbar-toggler-icon"></span>
                """;

        /*
            CR or CRLF line separators are turned into LF line separators.
            If you explicitly add escaped CR line separator it will remain with LF at the end.
            This ensures that the code is the same across the platforms.
            Check out the compiled code.
         */
        String crlfRemainsIfEscaped = """
                <div id="savbor-logo-mobile">\r
                <div id="savbor-logo-tablet">""";

        /*
            New String::formatted(Object... args) method has been added in jdk 13,
            that simplifies value substitution in text blocks.
         */
        String newStringMethodFormatted = """
                    public void print(%s x) {
                        System.out.println(x);
                    }
                """.formatted(String.class);
        System.out.println(newStringMethodFormatted);

        /*
            String literals can be concatenated with text blocks.
        */
        String concatenationOfLiteralAndTextBlock = "literal " + """
                text block""";

        /*--------------------------------- JDK 14 ----------------------------------*/

        /*
            Sometimes long lines are broken into smaller lines with "+",
            but it remains one line.
         */
        String longLiteral = "Lorem ipsum dolor sit amet. " +
                "consectetur adipiscing elit. In quam";

        /*
            To maintain one-line strings in text blocks,
            new escape line terminator ("\") has been added to java 14.
            A new escape line terminator can only be used with the text blocks.
            Check out the compiled code.
         */
        String newLineTerminatorIntroducedInJdk14 = """
                Lorem ipsum dolor sit amet. \
                consectetur adipiscing elit. In quam""";

        /*
            In jdk 14 single space escape sequence has been introduced ("\s").
         */
        String singleSpaceEscapeSequence = """
                Lorem ipsum dolor sit amet\s
                """;

        /*
            Single space escape sequences can be used in string literals as well.
         */
        String singleSpaceEscapeSequenceInStringLiteral = "Lorem ipsum\sdolor";

    }

}
