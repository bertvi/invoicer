import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar.js';
import { Link } from 'react-router-dom';

class ProjectList extends Component {

    constructor(props) {
        super(props);
        this.state = {projects: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/projects')
            .then(response => response.json())
            .then(data => this.setState({projects: data}));
    }

    async remove(id) {
        await fetch(`/api/projects/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProjects = [...this.state.projects].filter(i => i.id !== id);
            this.setState({projects: updatedProjects});
        });
    }

    render() {
        const {projects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const projectsList = projects.map(project => {
            return <tr key={project.id}>
                <td style={{whiteSpace: 'nowrap'}}>{project.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/projects/" + project.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(project.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/projects/new">Add Project</Button>
                    </div>
                    <h3>Projects</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {projectsList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default ProjectList;