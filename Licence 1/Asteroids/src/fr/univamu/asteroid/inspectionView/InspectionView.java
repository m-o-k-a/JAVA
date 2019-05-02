package fr.univamu.asteroid.inspectionView;

import javafx.event.Event;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;


/**
 * DO NOT MODIFY THIS CLASS!
 */
public class InspectionView {

  private final Inspection inspection;


  public InspectionView(TreeView treeView, Inspection inspection) {
    this.inspection = inspection;
    treeView.addEventFilter(KeyEvent.ANY, Event::consume);
    TreeItem<String> root = inspection.getItem();
    treeView.setRoot(root);
    root.setExpanded(true);
  }

  public void render() {
    inspection.update();
  }

}
