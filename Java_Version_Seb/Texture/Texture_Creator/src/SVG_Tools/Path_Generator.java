package SVG_Tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Path_Generator
{
    private static int id = 0;
    String header;
    String structure;
    String end;

    public Path_Generator()
    {
        createViewBox(5012,5012, 0, 0, 5000, 5000);
        // testPath();
        circle(2500, 2500, 1000, 20, 1,"none");
        endSVG();
    }


    public void saveSVG()
    {

        try {
            File file1 = new File("svg_test" + id + ".svg");
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("svg_test" + id + ".svg");
            fileWriter.write(header);
            fileWriter.write(structure);
            fileWriter.write(end);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        id++;
    }


    private void testViewbox()
    {
        String result = "<svg width=\""+ 512 + "\" height=\"" + 512 + "\" viewBox=\"-3.775377 -42.30107 144.356959 147.801089\" version=\"1.2\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" baseProfile=\"Full\">\n";
        this.header = result;
    }

    private void createViewBox(int width, int hight, int originX, int originY, int viewWidth, int viewHight)
    {
        String result = "<svg width=\""+ width + "\" height=\"" + hight + "\" viewBox=\"" + originX + " " + originY + " " + viewWidth + " " + viewHight + "\" version=\"1.2\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" baseProfile=\"Full\">\n";
        this.header = result;
    }

    private void testPath()
    {
        this.structure = "<path fill=\"none\" " +
                "stroke=\"blue\" " +
                "stroke-width=\"1px\" " +
                "transform=\"matrix(1,0,0,1,0,0)\" " +
                "d=\"M 70 30 q 0.466506 0.468696 1.055021 -0.160683 q 0.529113 -0.764957 -0.278312 -1.82735 q -0.968481 -1.043055 -2.776709 -0.511966 q -1.848076 0.710151 -2.220084 3.142734 q -0.198986 2.550856 2.278312 4.32735 q 2.680178 1.650105 5.941772 0.029915 q 3.229646 -1.888998 3.385148 -6.124785 q -0.13114 -4.336754 -4.278312 -6.82735 q -4.391875 -2.257156 -9.106836 0.452135 q -4.611215 3.067846 -4.550211 9.106836 q 0.461267 6.122652 6.278312 9.32735 q 6.103572 2.864207 12.2719 -0.934186 q 5.992785 -4.246694 5.715275 -12.088886 q -0.791394 -7.908551 -8.278312 -11.82735 q -7.815269 -3.471258 -15.436963 1.416237 q -7.374355 5.425541 -6.880338 15.070937 q 1.121521 9.694449 10.278312 14.32735 q 9.526965 4.078309 18.602026 -1.898287 q 8.755925 -6.604389 8.045402 -18.052988 q -1.451648 -11.480347 -12.278312 -16.82735 q -11.238662 -4.685359 -21.76709 2.380338 q -10.137495 7.783236 -9.210465 21.035039 q 1.781775 13.266246 14.278312 19.32735 q 12.950359 5.29241 24.932153 -2.862389 q 11.519065 -8.962084 10.375529 -24.01709 q -2.111902 -15.052144 -16.278312 -21.82735 q -14.662056 -5.899461 -28.097217 3.34444 q -12.900635 10.140931 -11.540592 26.99914 q 2.442029 16.838043 18.278312 24.32735 q 16.373753 6.506512 31.26228 -3.826491 q 14.282204 -11.319779 12.705656 -29.981191 q -2.772156 -18.623941 -20.278312 -26.82735 q -18.08545 -7.113563 -34.427344 4.308541 q -15.663774 12.498627 -13.870719 32.963242 q 3.102283 20.409839 22.278312 29.32735 q 19.797147 7.720613 37.592407 -4.790592 q 17.045344 -13.677474 15.035783 -35.945293 q -3.43241 -22.195738 -24.278312 -31.82735 q -21.508844 -8.327664 -40.757471 5.272643 q -18.426914 14.856322 -16.200846 38.927344 q 3.762537 23.981636 26.278312 34.32735 q 23.22054 8.934715 42.922534 -5.754694 q 19.808484 -16.035169 17.36591 -41.909394 q -4.092664 -25.767535 -28.278312 -36.82735 q -24.932237 -9.541766 -47.087598 6.236745 q -21.190054 17.214017 -18.530973 44.891445 q 4.422791 27.553433 30.278312 39.32735 q 26.643934 10.148817 50.252661 -6.718795 q 22.571624 -18.392864 19.696037 -47.873496 q -4.752918 -29.339331 -32.278312 -41.82735 q -28.355631 -10.755867 -53.417725 7.200846 q -23.953193 19.571712 -20.8611 50.855547 q 5.083045 31.12523 34.278312 44.32735 q 30.067328 11.362918 56.582788 -7.682897 q 25.334763 -20.75056 22.026164 -53.837598 q -5.413172 -32.911128 -36.278312 -46.82735 q -31.779025 -11.969969 -59.747852 8.164948 q -26.716333 21.929407 -23.191227 56.819648 q 5.7433 34.697026 38.278312 49.32735 q 33.490722 12.57702 62.912915 -8.647 \"/>\n";
    }

    private void circle(int centerx, int centery, int radius, int strokeWidth, int segmentAmount, String fill)
    {
        double segmentLength = calculateStroke_Dasharray(segmentAmount,radius);
        System.out.println(segmentLength);
        String circle = "<circle " +
                "cx=\"" + centerx + "\" " +
                "cy=\"" + centery + "\" " +
                "r=\""+ radius +"\" " +
                "transform=\"rotate(" + angleOfRotation(segmentAmount) + " " + centerx + " " + centery + ")\" " +
                "stroke-dasharray=\"" + segmentLength*4 + ", " + segmentLength*1 + "\" " +
                "stroke=\"black\" " +
                "stroke-width=\"" + strokeWidth + "\" " +
                "fill=\"" + fill + "\" " +
                "/>";

        this.structure = circle;
    }

    private void endSVG()
    {
        this.end = "</svg>";
    }

    private double calculateStroke_Dasharray(int segmentAmount, int radius)
    {
        double lengthOfCircle = 2*Math.PI*radius;
        double lengthOfSegment = lengthOfCircle/segmentAmount;
        double lengthOfLineInSegment = lengthOfSegment/5;
        return lengthOfLineInSegment;
    }

    private double angleOfRotation(int segmentAmount)
    {
        double angleOfSegment = 360.0/segmentAmount;
        double angleOfSegmentStroke = (angleOfSegment/5)*3;
        return angleOfSegmentStroke-90;
    }
}
