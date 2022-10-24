import React, { useEffect } from 'react'
import { useRouter } from 'next/router'
import NavBar from '../components/NavBar'

import styles from '../styles/Pcs.module.css'
import PcCard from '../components/PcCard'


function Pcs(props) {

    const { query } = useRouter();

    console.log(query.q)

    useEffect(() => {


        return () => {

        }
    }, [])

    return (
        <div className={styles.body}>

            <NavBar></NavBar>
            <main className={styles.main}>

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

                </section>

            </main>
        </div>
    )
}

export default Pcs