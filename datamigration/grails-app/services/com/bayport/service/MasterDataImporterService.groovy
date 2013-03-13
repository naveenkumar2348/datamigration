package com.bayport.service

import com.bayport.domain.FileUploader
import com.bayport.domain.FileUploaderError
import com.bayport.domain.StagingAgent
import com.bayport.enums.MasterDataSheetType
import com.bayport.enums.MigrationStatus
import com.qualica.flexifin.masterdata.shared.dto.AgentDTO
import com.qualica.flexifin.masterdata.shared.service.AgentService

class MasterDataImporterService {

    AgentService agentService;

    FileUploader exportToFlexiFin(FileUploader fileUploader){

        switch (fileUploader.getDataSheetType()){

            case MasterDataSheetType.AGENT :
                print "Inside Agent Case"
                return exportAgentDataToFlexiFin(fileUploader)
                break;

            case MasterDataSheetType.USER :
                break;

            case MasterDataSheetType.BANK :
                break;

            case MasterDataSheetType.THIRDPARTY :
                break;

            case MasterDataSheetType.CLIENT :
                break;

            case MasterDataSheetType.OUTLET :
                break;

            case MasterDataSheetType.EMPLOYER :
                break;
        }

        return fileUploader
    }

    FileUploader exportAgentDataToFlexiFin(FileUploader fileUploader){
        Set errors = new HashSet()
        List<AgentDTO> agentDTOs = new ArrayList<AgentDTO>()

        List agents =  StagingAgent.findAllByMigrationStatus(MigrationStatus.InStagingArea)

        if (agents?.size() == 0){
            FileUploaderError error = new FileUploaderError()
            error.setErrorMessage("there is records with status InSatingArea,Please make sure you have uploaded the sheet")
            errors.add(error)
            fileUploader.setErrorList(errors)
            return fileUploader
        }

        print "Agents Size"+agents?.size()
        agentDTOs = agents.toDTO(AgentDTO)
        print "Agetn1 DTO Size"+agentDTOs.size()
        for(AgentDTO agentDTO : agentDTOs){
            int agentFlexiFinId = agentService.saveAgent(agentDTO)
            print "agentFlexiFinId"+agentFlexiFinId
        }

        return fileUploader
    }

}
