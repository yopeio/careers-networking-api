package io.yope.careers.ethereumj;

import io.yope.careers.domain.Education;
import io.yope.careers.domain.Member;
import io.yope.careers.interfaces.CareerBlockchain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ethereum.core.CallTransaction;
import org.ethereum.core.Transaction;
import org.ethereum.crypto.ECKey;
import org.ethereum.facade.Ethereum;
import org.spongycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by enrico.mariotti on 28/01/2016.
 */
@Service
@Slf4j
@AllArgsConstructor
public class CareerEthereumj implements CareerBlockchain {

    private static final long GAS_PRICE = 1;
    private static final long GAS_LIMIT = 1;

    @Autowired
    EthereumFacade ethereumFacade;


    private EthereumSettings ethereumSettings;

    @Override
    public Member write(final Member member) {
        if (StringUtils.isNotBlank(member.getHash()) ) {
            return addEducation(member);
        }

        Ethereum ethereum = ethereumFacade.getEthereum();
        ECKey userKey = ECKey.fromPrivate(Hex.decode(ethereumSettings.getPrivateKey()));

        CallTransaction.Function writeMemberFunc = CallTransaction.Function.fromSignature("addEducation",
                "bytes32[]", "bytes32", "uint", "bytes32", "bytes32");

        byte[] accountAddr = userKey.getAddress();

        BigInteger nonce = ethereum.getRepository().getNonce(accountAddr);

        Transaction tx = CallTransaction.createCallTransaction(
                nonce.longValue(),
                GAS_PRICE, // => gas price
                GAS_LIMIT,       // => gas limit
                ethereumSettings.getCareerAccount(),     // => the contract address we actually updating
                1,               // => value,  can be zero
                writeMemberFunc,        // => abi definition of the call
                member.getName(),
                member.getSurname(),
                member.getBirthDate() // => params to update
        );
        tx.sign(userKey.getPrivKeyBytes());
        ethereum.submitTransaction(tx);
        return member;
    }

    Member addEducation(final Member member) {
        Ethereum ethereum = ethereumFacade.getEthereum();
        ECKey userKey = ECKey.fromPrivate(Hex.decode(ethereumSettings.getPrivateKey()));

        CallTransaction.Function addEducationFunc = CallTransaction.Function.fromSignature("addEducation",
                "bytes32[]", "bytes32", "uint", "bytes32", "bytes32");

        byte[] accountAddr = userKey.getAddress();

        BigInteger nonce = ethereum.getRepository().getNonce(accountAddr);

        Education education = member.getEducations().iterator().next();

        Transaction tx = CallTransaction.createCallTransaction(
                nonce.longValue(),
                GAS_PRICE, // => gas price
                GAS_LIMIT,       // => gas limit
                ethereumSettings.getCareerAccount(),     // => the contract address we actually updating
                1,               // => value,  can be zero
                addEducationFunc,        // => abi definition of the call
                education.getSchool().getName(),
                education.getSchool().getLocation(),
                education.getYear(), education.getTitle(),
                education.getCertificate().getData() // => params to update
        );
        tx.sign(userKey.getPrivKeyBytes());
        ethereum.submitTransaction(tx);
        return member;
    }

//    Function<School, String> schoolToName =
//            new Function<School,String>() {
//                public String apply(School school) { return school.getName(); }
//            };

    @Override
    public Member findByHash(final String hash) {
        return Member.builder().hash(hash).build();
    }
}
