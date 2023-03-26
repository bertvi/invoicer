import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar.js';
import { Link } from 'react-router-dom';

class UnitList extends Component {

    constructor(props) {
        super(props);
        this.state = {units: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/units')
            .then(response => response.json())
            .then(data => this.setState({units: data}));
    }

    async remove(id) {
        await fetch(`/api/units/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedUnits = [...this.state.units].filter(i => i.id !== id);
            this.setState({units: updatedUnits});
        });
    }

    render() {
        const {units, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const unitsList = units.map(unit => {
            return <tr key={unit.id}>
                <td style={{whiteSpace: 'nowrap'}}>{unit.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/units/" + unit.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(unit.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/activities/new">Add Unit</Button>
                    </div>
                    <h3>Units</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {unitsList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default UnitList;