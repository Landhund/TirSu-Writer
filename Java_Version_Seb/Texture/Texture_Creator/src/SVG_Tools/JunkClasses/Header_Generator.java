package SVG_Tools.JunkClasses;

public class Header_Generator
{

    String header;
    String svgSize;
    String viewbox;
    String headerEnd;

    public Header_Generator()
    {
        defaultHeader();
    }

    private void testViewbox()
    {
        String result = "<svg width=\""+ 512 + "\" height=\"" + 512 + "\" viewBox=\"-3.775377 -42.30107 144.356959 147.801089\" version=\"1.2\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" baseProfile=\"Full\">\n";
        this.header = result;
    }

    private void defaultHeader()
    {
        createSVGHeader(200,200);
        createViewBox(0, 0, 200, 200);
        createHeaderEnd();
    }

    public void createSVGHeader(int width, int hight)
    {
        svgSize = "<svg width=\""+ width + "\" height=\"" + hight + "\"";
    }

    public void createViewBox(int originX, int originY, int viewWidth, int viewHight)
    {
        viewbox = " viewBox=\"" + originX + " " + originY + " " + viewWidth + " " + viewHight ;
    }

    public void createCenteredOnOriginViewbox(int viewWidth, int viewHight)
    {
        viewbox = " viewBox=\"" + -viewWidth/2 + " " + -viewHight/2 + " " + viewWidth + " " + viewHight ;
    }

    private void createHeaderEnd()
    {
        headerEnd = "\" version=\"1.2\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" baseProfile=\"Full\">\n";
    }

    public String getHeader() {
        return svgSize + viewbox + headerEnd;
    }
}
