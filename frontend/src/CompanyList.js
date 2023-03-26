import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar.js';
import { Link } from 'react-router-dom';

class CompanyList extends Component {

    constructor(props) {
        super(props);
        this.state = {companies: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/companies')
            .then(response => response.json())
            .then(data => this.setState({companies: data}));
    }

    async remove(id) {
        await fetch(`/api/companies/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCompanies = [...this.state.companies].filter(i => i.id !== id);
            this.setState({companies: updatedCompanies});
        });
    }

    render() {
        const {companies, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const companiesList = companies.map(company => {
            return <tr key={company.id}>
                <td style={{whiteSpace: 'nowrap'}}>{company.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/companies/" + company.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(company.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/companies/new">Add Company</Button>
                    </div>
                    <h3>Companies</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {companiesList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default CompanyList;