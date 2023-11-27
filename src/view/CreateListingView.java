package view;

import interface_adapter.create_listing.CreateListingController;
import interface_adapter.create_listing.CreateListingViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.create_listing.CreateListingOutputBoundary;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageFilter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class CreateListingView extends JPanel implements ActionListener, PropertyChangeListener {
    /**
     * The View allowing sellers to input listing information to create a book.
     */
    final JButton upload;
    final JButton createListing;
    private final CreateListingViewModel createListingViewModel;
    private final CreateListingController createListingController;
    private final DecimalFormat listingPriceFormat = new DecimalFormat("##,###.00");
    private final JFormattedTextField listingPriceInputField = new JFormattedTextField(listingPriceFormat);
    private final JFileChooser bookPhotoChooser = new JFileChooser();
    private final String[] options = new String[]{"New", "Excellent", "Good", "Ok", "Poor"};
    private final String selectedCondition = "New";
    private final JComboBox<String> conditionDropdown = new JComboBox<String>(options);
    public CreateListingView(CreateListingViewModel createListingViewModel,
                             CreateListingController createListingController){
        this.createListingViewModel = createListingViewModel;
        this.createListingController = createListingController;
        this.createListingViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CreateListingViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel listingPrice = new LabelTextPanel(
                new JLabel(CreateListingViewModel.LISTING_PRICE_LABEL), listingPriceInputField);

        JPanel createListingPanel = new JPanel();
        upload = new JButton(CreateListingViewModel.UPLOAD_BUTTON_LABEL);
        createListing = new JButton(CreateListingViewModel.CREATE_LISTING_LABEL);
        createListingPanel.add(upload);
        createListingPanel.add(createListing);
        createListingPanel.add(conditionDropdown);

        upload.addActionListener(
            // This creates an anonymous subclass of ActionListener and instantiates it.
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(upload)) {
                        bookPhotoChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg",
                            "gif", "png", "jpeg");
                            bookPhotoChooser.setFileFilter(filter);
                        File image = bookPhotoChooser.getSelectedFile();
                    }
                }
            }
        );

        createListing.addActionListener(
            // This creates an anonymous subclass of ActionListener and instantiates it.
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(createListing)) {
                        LocalDateTime ltd = LocalDateTime.now();
                        createListingController.execute(book, seller, selectedCondition, image, ltd);
                        }
                    }
                }
        );

        conditionDropdown.addActionListener(
            // This creates an anonymous subclass of ActionListener and instantiates it.
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(conditionDropdown)) {
                        String selectedCondition = (String)conditionDropdown.getSelectedItem();
                        }
                    }
                }
        );
        listingPriceInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateListingState currentState = createListingViewModel.getState();
                        String text = listingPriceInputField.getText() + e.getKeyChar();
                        currentState.setListingPrice(text);
                        createListingViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
            });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
