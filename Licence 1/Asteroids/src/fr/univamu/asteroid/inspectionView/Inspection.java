package fr.univamu.asteroid.inspectionView;

import javafx.scene.control.TreeItem;

/**
 * DO NOT MODIFY THIS CLASS!
 */
public abstract class Inspection {

  protected TreeItem<String> item;
  public TreeItem<String> getItem() { return item; }

  public abstract void update();
}
