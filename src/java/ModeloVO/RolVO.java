/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author alrod
 */
public class RolVO {

    private String rolId, rolTiPo;

    public RolVO(String rolId, String rolTiPo) {
        this.rolId = rolId;
        this.rolTiPo = rolTiPo;
    }

    public RolVO() {

    }

    public RolVO(String rolId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getRolTiPo() {
        return rolTiPo;
    }

    public void setRolTiPo(String rolTiPo) {
        this.rolTiPo = rolTiPo;
    }

}
