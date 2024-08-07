package br.com.fiap.client_management.client_management.domain;

import br.com.fiap.client_management.client_management.infra.persistence.AddressEntity;
import br.com.fiap.client_management.client_management.infra.persistence.ClientEntity;

import static java.util.Objects.isNull;

public class Client {

    private String uuid;
    private String cpf;
    private String name;
    private String email;
    private String telephone;
    private Address address;

    public Client() {
    }

    private Client(String uuid, String name, String cpf, String email, String telephone, Address address) {
        this.uuid = uuid;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public static Client of(
            String uuid,
            String name,
            String cpf,
            String email,
            String telephone,
            Address address) {
        validate(name, cpf, email, telephone, address);
        return new Client(
                uuid,
                name,
                cpf,
                email,
                telephone,
                address);
    }

    public static ClientEntity toClientEntity(Client client) {
        Address address = client.getAddress();

        return new ClientEntity(
                null,
                client.getName(),
                client.getEmail(),
                client.getCpf(),
                client.getTelephone(),
                new AddressEntity(
                        null,
                        address.getStreet(),
                        address.getCity(),
                        address.getProvince(),
                        address.getCountry(),
                        address.getZipCode()));
    }

    public static Client toClient(ClientEntity clientEntity) {

        AddressEntity addressEntity = clientEntity.getAddress();

        Address address = Address.of(
                addressEntity.getStreet(),
                addressEntity.getCity(),
                addressEntity.getProvince(),
                addressEntity.getZipCode(),
                addressEntity.getCountry());

        return Client.of(
                clientEntity.getId(),
                clientEntity.getName(),
                clientEntity.getCpf(),
                clientEntity.getEmail(),
                clientEntity.getTelephone(),
                address);

    }

    private static void validate(String name, String cpf, String email, String telephone, Address address) {

        final String CPF_REGEX = "^\\d{11}$";
        final String NAME_REGEX = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
        final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        final String TELEPHONE_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";


        if (isNull(name) || name.isEmpty() || !name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("O nome informado é inválido.");
        }
        if (isNull(cpf) || cpf.isEmpty() || !cpf.matches(CPF_REGEX)) {
            throw new IllegalArgumentException("Informe um CPF com 11 números sem pontuação.");
        }
        if (isNull(email) || email.isEmpty() || !email.matches(EMAIL_REGEX) ) {
            throw new IllegalArgumentException("O Email informado não é válido.");
        }
        if (isNull(telephone) || telephone.isEmpty() || !email.matches(TELEPHONE_REGEX) ) {
            throw new IllegalArgumentException("O telefone informado não é válido.");
        }
        if (isNull(address)) {
            throw new IllegalArgumentException("Preencha os campos do endereço com valores válidos.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
