package com.suipacha.jsfController;

import com.suipacha.jpa.TbExpediente;
import com.suipacha.jsfController.util.JsfUtil;
import com.suipacha.jsfController.util.JsfUtil.PersistAction;
import com.suipacha.jsf.TbExpedienteFacade;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tbExpedienteController")
@SessionScoped
public class TbExpedienteController implements Serializable {

    @EJB
    private com.suipacha.jsf.TbExpedienteFacade ejbFacade;
    private List<TbExpediente> items = null;
    private List<TbExpediente> itemsFiltered = null;
    
    private TbExpediente selected;

    private String caratulaSelected;

    public String getCaratulaSelected() {
        return caratulaSelected;
    }

    public void setCaratulaSelected(String caratulaSelected) {
        this.caratulaSelected = caratulaSelected;
    }

    public List<TbExpediente> getItemsFiltered() {
        return itemsFiltered;
    }

    public void setItemsFiltered(List<TbExpediente> itemsFiltered) {
        this.itemsFiltered = itemsFiltered;
    }

    
    public TbExpedienteController() {
    }

    public TbExpediente getSelected() {
        return selected;
    }

    public void setSelected(TbExpediente selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TbExpedienteFacade getFacade() {
        return ejbFacade;
    }

    public TbExpediente prepareCreate() throws ParseException {
        selected = new TbExpediente();
        
        initializeEmbeddableKey();
        
        Calendar currentDate = Calendar.getInstance(); //Get the current date 
    SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyy"); //format it as per your requirement 
    String dateNow = formatter.format(currentDate.getTime()); 
    Date dateAhora = formatter.parse(dateNow);
//System.out.println("Now the date is :=> " + dateNow); 
        selected.setFechaInicio(dateAhora);
        
        
        
        
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TbExpedienteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TbExpedienteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TbExpedienteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TbExpediente> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TbExpediente getTbExpediente(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TbExpediente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TbExpediente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TbExpediente.class)
    public static class TbExpedienteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TbExpedienteController controller = (TbExpedienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tbExpedienteController");
            return controller.getTbExpediente(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TbExpediente) {
                TbExpediente o = (TbExpediente) object;
                return getStringKey(o.getExpedienteID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TbExpediente.class.getName()});
                return null;
            }
        }

    }

    
    public void filtrarPorDniOCaratula(String caratulaSelected) {
        
        System.out.println("HOLA VINE A filtrarPorDniOCaratula");
        this.itemsFiltered = new ArrayList<TbExpediente>();
        if (caratulaSelected != null) {
            for (TbExpediente expediente : getItems()) {
                if (expediente.getNroCaratula() != null) {
                    if (expediente.getNroCaratula().equals(caratulaSelected)) {
                        itemsFiltered.add(expediente);
                    }
                }
                
                System.out.println("ACA 5: "+expediente.toString());
                
                     
                FacesContext context = FacesContext.getCurrentInstance();
                TbDatosPersonalesController tbDatosPersonalesController = context.getApplication().evaluateExpressionGet(context, "#{tbDatosPersonalesController}", TbDatosPersonalesController.class);
        
                
                
                System.out.println("ACA 4: "+expediente.getDemandante());
                System.out.println("ACA 6: "+tbDatosPersonalesController.toString());
                
                
                
                if(tbDatosPersonalesController.getTbDatosPersonales(expediente.getDemandante()).getDocumento() != null){
                        
                if ( String.valueOf(tbDatosPersonalesController.getTbDatosPersonales(expediente.getDemandante()).getDocumento()).equals(caratulaSelected)) {
                        itemsFiltered.add(expediente);
                        }
                }
                
            }
        }
    }
    
    
}
