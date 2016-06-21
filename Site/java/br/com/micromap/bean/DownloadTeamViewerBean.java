package br.com.micromap.bean;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "MBDownTeamViewer")
public class DownloadTeamViewerBean {
	
	private StreamedContent fileTeamViewer;

	public DownloadTeamViewerBean() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/assets/instaladores/TeamViewer_Setup_7_pt.exe");
		fileTeamViewer = new DefaultStreamedContent(stream, "arquivo/exe", "TeamViewer_Setup_7_pt.exe");
		
	}
	
	public StreamedContent getFile() {
		return fileTeamViewer;
    }
	
//	public StreamedContent licitaMap() {
//		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
//				.getResourceAsStream("/assets/instaladores/LICITAMAP.exe");
//		fileLicitaMap = new DefaultStreamedContent(stream, "arquivo/exe", "LICITAMAP.exe");
//		return fileLicitaMap;
//	}
}
