import React, { useEffect } from 'react'
import { useRouter } from 'next/router'
import NavBar from '../components/NavBar'

import styles from '../styles/Pcs.module.css'
import PcCard from '../components/PcCard'
import Head from 'next/head'


import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

import { faSortDown } from "@fortawesome/free-solid-svg-icons";

function Pcs(props) {

    const { query } = useRouter();


    useEffect(() => {


        return () => {

        }
    }, [])

    const showOptions= () =>{
        const options = document.getElementById('options')
        options.classList.add(styles.hidden)
    }

    return (
        <div className={styles.body}>
            <Head>
                <title>HPBE</title>
            </Head>

            <NavBar></NavBar>
            <main className={styles.main}>
                <aside className={styles.aside}>

                    <div className={styles.aside__pctype}>

                        <p>Seleccion el tipo de pc:</p>
                        <input type="radio" name="pc_type" id="oficina" />
                        <label htmlFor="oficina">Oficina</label>
                        <input type="radio" name="pc_type" id="gamer" />
                        <label htmlFor="gamer">Gamer</label>
                        <input type="radio" name="pc_type" id="diseño" />
                        <label htmlFor="diseño">Diseño</label>
                        
                    </div>

                    <div className={styles.aside__order} onClick={showOptions}>
                        <div className={styles.aside__order__select}>
                            <span>Ordenar por...</span>
                            
                            <FontAwesomeIcon icon={faSortDown} />
                        </div>

                        <div id='options'>
                            <span>Menor a mayor</span>
                            <span>Mayor a menor</span>
                        </div>

                    </div>

                </aside>

                <section className={styles.section}>

                    <PcCard
                        img="/oficina.png"
                        name="Pc Oficina"
                        description="Componentes gama baja"
                        precio="2000"
                    ></PcCard>
                    <PcCard
                        img="/gamer.png"
                        name="Pc Gamer"
                        description="Componentes gama media"
                        precio="3500"
                    ></PcCard>
                    <PcCard
                        img="diseño.png"
                        name="Pc Diseño"
                        description="Componentes gama alta"
                        precio="5000"
                    ></PcCard>
                    <PcCard
                        img="/oficina.png"
                        name="Pc Oficina"
                        description="Componentes gama baja"
                        precio="2000"
                    ></PcCard>
                    <PcCard
                        img="/gamer.png"
                        name="Pc Gamer"
                        description="Componentes gama media"
                        precio="3500"
                    ></PcCard>
                    <PcCard
                        img="diseño.png"
                        name="Pc Diseño"
                        description="Componentes gama alta"
                        precio="5000"
                    ></PcCard>

                    <PcCard
                        img="/oficina.png"
                        name="Pc Oficina"
                        description="Componentes gama baja"
                        precio="2000"
                    ></PcCard>
                    <PcCard
                        img="/gamer.png"
                        name="Pc Gamer"
                        description="Componentes gama media"
                        precio="3500"
                    ></PcCard>
                    <PcCard
                        img="diseño.png"
                        name="Pc Diseño"
                        description="Componentes gama alta"
                        precio="5000"
                    ></PcCard>
                    <PcCard
                        img="/oficina.png"
                        name="Pc Oficina"
                        description="Componentes gama baja"
                        precio="2000"
                    ></PcCard>
                    <PcCard
                        img="/gamer.png"
                        name="Pc Gamer"
                        description="Componentes gama media"
                        precio="3500"
                    ></PcCard>
                    <PcCard
                        img="diseño.png"
                        name="Pc Diseño"
                        description="Componentes gama alta"
                        precio="5000"
                    ></PcCard>

                </section>

            </main>
        </div>
    )
}

export default Pcs