package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public interface ButtonListener {
    public MouseAdapter getButtonAdapter(GameButton button);
}
