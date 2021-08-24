package pages;

import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import infra.enums.ShapeEnum;
import infra.ui.BaseWE;
import infra.ui.DrawToolBarWE;
import infra.ui.EditToolBarWE;
import infra.ui.ZoomToolBarWE;

public class GeoEditorPage extends BasePage {

    DrawToolBarWE drawToolBarWe = new DrawToolBarWE("draw toolbar", BaseWE.LocateBy.ClassName, "leaflet-pm-draw");
    EditToolBarWE editToolBarWe = new EditToolBarWE("edit toolbar", BaseWE.LocateBy.ClassName, "leaflet-pm-edit");
    ZoomToolBarWE zoomToolBarWE= new ZoomToolBarWE("zoom toolbar", BaseWE.LocateBy.ClassName,"leaflet-control-zoom");

    public void draw(TestCreateDTO dto) {
        ShapeEnum shape = ShapeEnum.valueOf(dto.getShape());
        if (shape == ShapeEnum.CIRCLE) {
            drawToolBarWe.drawCircle(dto);
        } else if (shape == ShapeEnum.POLYLINE) {
            drawToolBarWe.drawPolyline(dto);
        } else if (shape == ShapeEnum.POLYGONS) {
            drawToolBarWe.drawPolygons(dto);
        }
    }

    public void drag(TestEditDTO dto){
        editToolBarWe.drag(dto);
    }

    public void edit(TestEditDTO dto){
        editToolBarWe.edit(dto);
    }

    public void cut(TestEditDTO dto){
        editToolBarWe.cut(dto);
    }

    public void delete(){
        editToolBarWe.delete(null);
    }

    public void zoomIn(){
        zoomToolBarWE.zoomIn();
    }

    public void zoomOut(){
        zoomToolBarWE.zoomOut();
    }

}
