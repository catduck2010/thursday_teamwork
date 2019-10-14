package com.travel.util;

/**
 * <code>SeatChooserJButton from DateChooserJButton</code>
 *
 * @author Lihang Zhou
 * based on DateChooserJButton.java
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;

public class SeatChooserJButton extends JButton {

    private SeatChooser seatChooser = null;
    private String selected = "";
    private int[][] seatTable;

    public SeatChooserJButton() {
        seatTable = null;
        super.setText("Pick...");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seatChooser == null) {
                    seatChooser = new SeatChooser();
                }
                Point p = getLocationOnScreen();
                p.x = p.x + 90;
                selected = getText();
                seatChooser.showSeatChooser(p);
            }
        });
    }

    public SeatChooserJButton(int[][] seatTable) {
        this();
        this.seatTable = seatTable;
    }

    public void setSeat(String str) {
        super.setText(str);
        selected=str;
    }

    public String getSeat() {
        return selected;
    }

    public void setSeatTable(int[][] tbl) {
        this.seatTable = tbl;
    }

    private class SeatChooser extends JPanel implements ActionListener, ChangeListener {

        int width = 350;
        int height = 450;

        int startNum = 1;
        Color backGroundColor = Color.gray;

        Color palletTableColor = Color.white;
        Color colorBtnSelected = Color.GREEN;
        Color weekFontColor = Color.blue;
        Color colorNormalText = Color.black;
        Color weekendFontColor = Color.red;

        Color controlLineColor = Color.getHSBColor(0.58f, 1.00f, 0.54f);
        Color controlTextColor = Color.white;

        Color rbFontColor = Color.white;
        Color rbBorderColor = Color.red;
        Color rbButtonColor = Color.pink;
        Color rbBtFontColor = Color.red;

        Color labelColor = Color.BLUE;
        JDialog dialog;
        JButton[][] seatsButton = new JButton[5][6];
        JButton btnUp, btnDown;
        JLabel[] lineLabel;

        public SeatChooser() {
            setLayout(new BorderLayout());
            setBorder(new LineBorder(backGroundColor, 2));
            setBackground(backGroundColor);

            JPanel topPanel = createUpDownPanel();
            add(topPanel, BorderLayout.NORTH);
            JPanel centerSeatsPanel = createSeatsPanel();
            add(centerSeatsPanel, BorderLayout.CENTER);
            JPanel bottomPanel = createBottomPanel();
            add(bottomPanel, BorderLayout.SOUTH);
        }

        private JPanel createUpDownPanel() {
            JPanel result = new JPanel();

            result.setLayout(new FlowLayout());
            result.setBackground(controlLineColor);

            btnUp = new JButton("↑");
            result.add(btnUp);
            JLabel jl = new JLabel("Seats");
            jl.setForeground(Color.WHITE);
            result.add(jl);
            btnDown = new JButton("↓");
            result.add(btnDown);

            btnUpDownControl();
            btnUp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startNum -= 5;
                    flushSeats(startNum);
                    btnUpDownControl();
                }

            });

            btnDown.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startNum += 5;
                    flushSeats(startNum);
                    btnUpDownControl();
                }

            });

            return result;
        }

        private void btnUpDownControl() {
            if (startNum == 1) {
                btnUp.setEnabled(false);
            } else {
                btnUp.setEnabled(true);
            }
            if (startNum == 21) {
                btnDown.setEnabled(false);
            } else {
                btnDown.setEnabled(true);
            }
        }

        private JPanel createSeatsPanel() {
            String colname[] = {"Window", "", "", "Aisle", "", "", "Window"};
            JPanel result = new JPanel();
            result.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
            result.setLayout(new GridLayout(6, 7));
            result.setBackground(Color.white);
            JLabel cell;

            for (int i = 0; i < 7; i++) {
                cell = new JLabel(colname[i]);
                cell.setHorizontalAlignment(JLabel.CENTER);
                if (i == 0 || i == 6) {
                    cell.setForeground(weekendFontColor);
                } else {
                    cell.setForeground(weekFontColor);
                }
                result.add(cell);
            }
            lineLabel = new JLabel[5];
            //int actionCommandId = 0;
            int start = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 7; j++) {
                    if (j == 3) {
                        cell = new JLabel(String.valueOf(start++));
                        cell.setHorizontalAlignment(JLabel.CENTER);
                        cell.setForeground(labelColor);
                        lineLabel[i] = cell;
                        result.add(cell);
                        continue;
                    }
                    JButton numberButton = new JButton();
                    numberButton.setBorder(null);
                    numberButton.setHorizontalAlignment(SwingConstants.CENTER);
                    //numberButton.setActionCommand(String.valueOf(actionCommandId));
                    numberButton.addActionListener(this);
                    numberButton.setBackground(palletTableColor);
                    numberButton.setForeground(colorNormalText);
                    if (j > 3) {
                        seatsButton[i][j - 1] = numberButton;
                    } else {
                        seatsButton[i][j] = numberButton;
                    }
                    result.add(numberButton);

                }
            }
            return result;
        }

        // Lihang wrote this
        private JPanel createBottomPanel() {
            JPanel result = new JPanel();

            result.setBackground(Color.white);
            result.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton btnOK = new JButton();
            btnOK.setText("OK");
            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.setVisible(false);
                }
            });
            result.add(btnOK);

            return result;
        }
        //end of my turn

        private JDialog createDialog(Frame owner) {
            JDialog result = new JDialog(owner, "Choose a Seat", true);
            result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            result.getContentPane().add(this, BorderLayout.CENTER);
            result.pack();
            result.setSize(width, height);
            return result;
        }

        protected void showSeatChooser(Point position) {
            Frame owner = (Frame) SwingUtilities.getWindowAncestor(SeatChooserJButton.this);
            if (dialog == null || dialog.getOwner() != owner) {
                dialog = createDialog(owner);
            }
            dialog.setLocation(getAppropriateLocation(owner, position));
            flushSeats(startNum);
            dialog.setVisible(true);

        }

        protected Point getAppropriateLocation(Frame owner,
                Point position) {
            Point result = new Point(position);
            Point p = owner.getLocation();
            int offsetX = (position.x + width) - (p.x + owner.getWidth());
            int offsetY = (position.y + height) - (p.y + owner.getHeight());
            if (offsetX > 0) {
                result.x -= offsetX;
            }
            if (offsetY > 0) {
                result.y -= offsetY;
            }
            return result;

        }

        private void seatsColorUpdate() {
            for (JButton[] row : seatsButton) {
                for (JButton j : row) {
                    if (!selected.equals(j.getText())) {
                        j.setForeground(colorNormalText);
                    } else {
                        j.setForeground(colorBtnSelected);
                    }
                }
            }
        }

        private void seatsEnabledUpdate() {
            if (seatTable == null) {
                return;
            }
            for (int i = startNum - 1; i < startNum + 4; i++) {
                for (int j = 0; j < 6; j++) {
                    //System.out.println(i + ", " + j + ", " + seatTable[i][j]);
                    if (seatTable[i][j] > 0) {
                        seatsButton[i % 5][j].setEnabled(false);
                    } else {
                        seatsButton[i % 5][j].setEnabled(true);
                    }
                }
            }
        }

        private void flushSeats(int start) {
            char a;
            for (int i = 0; i < 5; i++) {
                lineLabel[i].setText(String.valueOf(start));
                a = 'A';
                for (int j = 0; j < 6; j++) {
                    //if(j==3)continue;
                    String s = String.valueOf(start) + String.valueOf(a++);
                    seatsButton[i][j].setText(s);
                    if (j == 2) {
                        a = 'H';
                    }
                    if (j == 3) {
                        a = 'J';
                    }
                }
                start++;
            }
            seatsEnabledUpdate();
            seatsColorUpdate();
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            seatsColorUpdate();
            flushSeats(startNum);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.getText().length() == 0) {
                return;
            }

            source.setForeground(colorBtnSelected);
            selected = source.getText();
            setSeat(selected);
            seatsColorUpdate();
        }
    }
}
