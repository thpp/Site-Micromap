package br.com.micromap.bean;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "MBDownLicitaMap")
public class DownloadLicitaMapBean {

	private StreamedContent fileLicitaMap;

	public DownloadLicitaMapBean() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/assets/instaladores/LICITAMAP.exe");
		fileLicitaMap = new DefaultStreamedContent(stream, "arquivo/exe", "LICITAMAP.exe");
		
	}
	
	public StreamedContent getFile() {
		return fileLicitaMap;
    }
	
}
