package com.suipacha.jsfController;

import com.suipacha.jpa.TbDatosPersonales;
import com.suipacha.jsfController.util.JsfUtil;
import com.suipacha.jsfController.util.JsfUtil.PersistAction;
import com.suipacha.jsf.TbDatosPersonalesFacade;

import java.io.Serializable;
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

@Named("tbDatosPersonalesController")
@SessionScoped
public class TbDatosPersonalesController implements Serializable {

    @EJB
    private com.suipacha.jsf.TbDatosPersonalesFacade ejbFacade;
    private List<TbDatosPersonales> items = null;
    private TbDatosPersonales selected;

    public TbDatosPersonalesController() {
    }

    public TbDatosPersonales getSelected() {
        return selected;
    }

    public void setSelected(TbDatosPersonales selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TbDatosPersonalesFacade getFacade() {
        return ejbFacade;
    }

    public TbDatosPersonales prepareCreate() {
        selected = new TbDatosPersonales();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TbDatosPersonalesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TbDatosPersonalesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TbDatosPersonalesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TbDatosPersonales> getItems() {
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

    public TbDatosPersonales getTbDatosPersonales(java.lang.Integer id) {
        
        return getFacade().find(id);
        
    }

    public List<TbDatosPersonales> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TbDatosPersonales> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TbDatosPersonales.class)
    public static class TbDatosPersonalesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TbDatosPersonalesController controller = (TbDatosPersonalesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tbDatosPersonalesController");
            return controller.getTbDatosPersonales(getKey(value));
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
            if (object instanceof TbDatosPersonales) {
                TbDatosPersonales o = (TbDatosPersonales) object;
                return getStringKey(o.getPersonaID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TbDatosPersonales.class.getName()});
                return null;
            }
        }

    }

}
