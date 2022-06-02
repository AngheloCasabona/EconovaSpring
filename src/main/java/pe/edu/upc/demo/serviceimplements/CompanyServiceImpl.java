package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.repositories.ICompanyRepository;
import pe.edu.upc.demo.serviceinterface.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService{

	private ICompanyRepository companyRepository;
	
	@Override
	public void Insert(Empresa company) {
		companyRepository.save(company);
	}

	@Override
	public List<Empresa> list() {
		return companyRepository.findAll();
	}

	@Override
	public void delete(int idCompany) {
		companyRepository.deleteById(idCompany);
	}

}

