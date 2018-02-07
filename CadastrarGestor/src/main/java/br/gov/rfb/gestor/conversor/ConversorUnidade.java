package br.gov.rfb.gestor.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.rfb.gestor.modelo.Unidade;
import br.gov.rfb.gestor.repositorio.RepositorioUnidades;
import br.gov.rfb.gestor.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Unidade.class)
public class ConversorUnidade implements Converter{
	
	private RepositorioUnidades repositorioUnidades;
	
	public ConversorUnidade() {
		repositorioUnidades = CDIServiceLocator.getBean(RepositorioUnidades.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Unidade retorno = null;
		
		if(value != null) {
			Long id = new Long(value);
			retorno = repositorioUnidades.buscarPorId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return Long.toString(((Unidade) value).getId());
		}
		
		return "";
	}

}
