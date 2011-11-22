/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stargate;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

/**
 *
 * @author Christopher
 */
public class unselectedButtonGroup extends ButtonGroup{

  @Override
  public void setSelected(ButtonModel model, boolean selected) {

    if (selected) {
      super.setSelected(model, selected);
    } else {
      clearSelection();
    }
  }

}
