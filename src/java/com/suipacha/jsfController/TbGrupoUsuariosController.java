package com.suipacha.jsfController;

import com.suipacha.jpa.TbGrupoUsuarios;
import com.suipacha.jsfController.util.JsfUtil;
import com.suipacha.jsfController.util.JsfUtil.PersistAction;
import com.suipacha.jsf.TbGrupoUsuariosFacade;

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

@Named("tbGrupoUsuariosController")
@SessionScoped
public class TbGrupoUsuariosController implements Serializable {

    @EJB
    private com.suipacha.jsf.TbGrupoUsuariosFacade ejbFacade;
    private List<TbGrupoUsuarios> items = null;
    private TbGrupoUsuarios selected;

    public TbGrupoUsuariosController() {
    }

    public TbGrupoUsuarios getSelected() {
        return selected;
    }

    public void setSelected(TbGrupoUsuarios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TbGrupoUsuariosFacade getFacade() {
        return ejbFacade;
    }

    public TbGrupoUsuarios prepareCreate() {
        selected = new TbGrupoUsuarios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TbGrupoUsuariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TbGrupoUsuariosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TbGrupoUsuariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TbGrupoUsuarios> getItems() {
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

    public TbGrupoUsuarios getTbGrupoUsuarios(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TbGrupoUsuarios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TbGrupoUsuarios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TbGrupoUsuarios.class)
    public static class TbGrupoUsuariosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TbGrupoUsuariosController controller = (TbGrupoUsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tbGrupoUsuariosController");
            return controller.getTbGrupoUsuarios(getKey(value));
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
            if (object instanceof TbGrupoUsuarios) {
                TbGrupoUsuarios o = (TbGrupoUsuarios) object;
                return getStringKey(o.getGrupousuarioID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TbGrupoUsuarios.class.getName()});
                return null;
            }
        }

    }

}
